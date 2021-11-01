/**
 * @author Jaden Heinle
 */

package FistBump;

public class Employment {
    private String jobTitle;
    private String companyName;
    private String roll; //TODO Job type? Refer to scenarios for clarification
    private String startDate;
    private String endDate;
    //private String contactInfo; //TODO This may not be needed
    private String jobDescription;

    public Employment() {
        jobTitle = "";
        companyName = "";
        roll = "";
        startDate = "";
        endDate = "";
        //contactInfo = "";
        jobDescription = "";
        
    }

    public Employment(String jobTitle, String companyName, String startDate, String endDate/*, String contactInfo*/, String jobDescription) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        //this.contactInfo = contactInfo;
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

    public String getRoll() {
        return roll;
    }

    public String getJobDescription() {
        return jobDescription;
    }
    /*public String getContactInfo() {
        return this.contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    */
}
