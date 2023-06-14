import java.util.Date;

public class JobApplication {
    private int id;
    private String company_name;
    private String job_title;
    private String application_status;
    private Date appliedDate;

    public JobApplication(String company_name, String job_title, String application_status, Date appliedDate) {
        this.company_name = company_name;
        this.job_title = job_title;
        this.application_status = application_status;
        this.appliedDate = appliedDate;
    }

    public int getId() {
        return id;
    }


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getApplication_status() {
        return application_status;
    }

    public void setApplication_status(String application_status) {
        this.application_status = application_status;
    }

    public java.sql.Date getAppliedDate() {
        return (java.sql.Date) appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }
}
