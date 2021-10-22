/**
 * @author Jaden Heinle
 */

package FistBump;

public class Employment {
    private String jobTitle;
    private String companyName;
    private String startDate;
    private String endDate;
    private String contactInfo;

    public Employment(){
        jobTitle = "";
        companyName = "";
        startDate = "";
        endDate = "";
        contactInfo = "";
    }
    public Employment(String jobTitle, String companyName, String startDate, String endDate, String contactInfo) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contactInfo = contactInfo;
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
    public String setStartDate() {
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
    public String getContactInfo() {
        return this.contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    /**
     * Last Updated: October 22, 2021
     * By: Cameron Delk
     */
}
