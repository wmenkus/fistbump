/**
 * @author Jaden Heinle
 */

package FistBump;

public class Employment {
    private String jobTitle;
    private String companyName;
    private String jobType; 
    private String startDate;
    private String endDate;
    private String jobDescription;

    public Employment() {
        jobTitle = "";
        companyName = "";
        jobType = "";
        startDate = "";
        endDate = "";
        //contactInfo = "";
        jobDescription = "";
        
    }

    public Employment(String jobTitle, String companyName,String jobType, String startDate, String endDate, String jobDescription) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobType = jobType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    public String toString() {
        return (
            jobTitle + "\n" +
            "\t" + companyName + "\n" +
            "\t" + jobType + "\n" +
            "\t" + startDate + " - " + endDate + "\n" +
            "\t" + jobDescription
        );
    }

}
