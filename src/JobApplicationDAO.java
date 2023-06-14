import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class JobApplicationDAO {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jobApplications";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public void createTable() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String createTable = "CREATE TABLE IF NOT EXISTS appliedJobs (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "company_name VARCHAR(255)," +
                    "job_title VARCHAR(255)," +
                    "application_status VARCHAR(255)," +
                    "applied_date DATE" +
                    ");";
            PreparedStatement preparedStatement = connection.prepareStatement(createTable);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Table Created Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertJobApplication(JobApplication application) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String insertSql = "INSERT INTO appliedJobs (company_name, job_title, application_status, applied_date)" +
                    "VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertSql);

            preparedStatement.setString(1, application.getCompany_name());
            preparedStatement.setString(2, application.getJob_title());
            preparedStatement.setString(3, application.getApplication_status());
            preparedStatement.setDate(4, application.getAppliedDate());

            preparedStatement.executeUpdate();

            System.out.println("Insertion Done Successfully");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<JobApplication> getAllData() {
        List<JobApplication> applications = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String selectSql = "SELECT * FROM appliedJobs";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String companyName = resultSet.getString("company_name");
                String jobTitle = resultSet.getString("job_title");
                String applicationStatus = resultSet.getString("application_status");
                Date appliedDate = resultSet.getDate("applied_date");
                JobApplication jobApplication = new JobApplication(companyName, jobTitle, applicationStatus, appliedDate);
                applications.add(jobApplication);
            }
            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return applications;
    }

    public void UpdateApplication(JobApplication application) {

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String updateSql = "UPDATE appliedJobs SET application_status = ? WHERE company_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);

            preparedStatement.setString(1, application.getApplication_status());
            preparedStatement.setString(2, application.getCompany_name());

            preparedStatement.executeUpdate();
            System.out.println("Job Application Updated Successfully!");

            connection.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteJobApplication(String companyName) {

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String deleteSql = "DELETE FROM appliedJobs WHERE company_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setString(1, companyName);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
            System.out.println(companyName + " Delete Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JobApplication getCompanyInfo(String companyName) {
        JobApplication application = null;
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String selectSql = "SELECT * FROM appliedJobs WHERE company_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setString(1, companyName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String jobTitle = resultSet.getString("job_title");
                String applicationStatus = resultSet.getString("application_status");
                Date appliedDate = resultSet.getDate("applied_date");
                application = new JobApplication(companyName, jobTitle, applicationStatus, appliedDate);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return application;
    }

}
