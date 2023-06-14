import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobApplicationDAO dao = new JobApplicationDAO();
        dao.createTable();
        String companyName, jobTitle, applicationStatus;
        Date appliedDate;
        JobApplication application = null;

        while (true) {
            System.out.println("""
                    Please select your Choice:
                    1 -> To Insert\s
                    2 -> To Update Application Status\s
                    3 -> To View All Applications\s
                    4 -> To Delete Application\s
                    5 -> To Get Specific Company Info\s
                    0 -> Exit\s
                    """);
            int choice = sc.nextInt();
            switch (choice) {
                case 0 -> {
                    System.exit(0);
                }
                case 1 -> {
                    System.out.print("Please Enter Company Name : \n");
                    sc.nextLine();
                    companyName = sc.nextLine();
                    System.out.println("Please Enter Job Title : ");
                    jobTitle = sc.nextLine();
                    System.out.println("Please Enter Application Status : ");
                    applicationStatus = sc.nextLine();
                    System.out.print("Enter the applied date (yyyy-mm-dd): ");
                    String dateInput = sc.nextLine();
                    appliedDate = Date.valueOf(dateInput);
                    application = new JobApplication(companyName, jobTitle, applicationStatus, appliedDate);
                    dao.insertJobApplication(application);
                }
                case 2 -> {
                    System.out.println("Please Enter the Company Name: ");
                    sc.nextLine();
                    companyName = sc.nextLine();
                    System.out.println("Please Enter the Application Status: ");
                    applicationStatus = sc.nextLine();
                    JobApplication temp = dao.getCompanyInfo(companyName);
                    application = new JobApplication(companyName, temp.getJob_title(), applicationStatus, temp.getAppliedDate());
                    dao.UpdateApplication(application);
                }

                case 3 -> {
                    List<JobApplication> jobApplicationList = dao.getAllData();

                    if (jobApplicationList.isEmpty()) {
                        System.out.println("No data found.");
                        return;
                    }

                    System.out.println("ID\tCompany Name\tJob Title\tApplication Status\tApplied Date");
                    System.out.println("-------------------------------------------------------------");

                    for (JobApplication item : jobApplicationList) {
                        int id = item.getId();
                        String company_name = item.getCompany_name();
                        String job_title = item.getJob_title();
                        String application_status = item.getApplication_status();
                        Date applied_date = item.getAppliedDate();

                        System.out.format("%d\t | %s\t | %s\t | %s\t | %s | %n", id, company_name, job_title, application_status, applied_date);
                    }
                }
                case 4 -> {
                    System.out.println("Please Enter the Company Name: ");
                    sc.nextLine();
                    companyName = sc.nextLine();
                    dao.deleteJobApplication(companyName);
                }
                case 5 -> {
                    System.out.println("Please Enter the Company Name: ");
                    sc.nextLine();
                    companyName = sc.nextLine();
                    application = dao.getCompanyInfo(companyName);

                    int id = application.getId();
                    String company_name = application.getCompany_name();
                    String job_title = application.getJob_title();
                    String application_status = application.getApplication_status();
                    Date applied_date = application.getAppliedDate();
                    System.out.println("ID\tCompany Name\tJob Title\tApplication Status\tApplied Date");
                    System.out.println("-------------------------------------------------------------");
                    System.out.format("%d\t | %s\t | %s\t | %s\t | %s | %n", id, company_name, job_title, application_status, applied_date);
                }
            }
        }

    }
}