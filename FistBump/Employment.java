/**
 * The applicant's past employment experience.
 * @author Jaden Heinle
 */

package FistBump;

import java.util.ArrayList;

public class Employment {
    private String jobTitle;
    private String companyName;
    private String jobType; 
    private String startDate;
    private String endDate;
    private ArrayList<String> descriptions;

    /**
     * The default constructor for Employment.
     * All variables set to empty Strings.
     */
    public Employment() {
        jobTitle = "";
        companyName = "";
        jobType = "";
        startDate = "";
        endDate = "";
        descriptions = new ArrayList<String>();
        
    }

    /**
     * The parameterized constructor for Employment.
     */
    public Employment(String jobTitle, String companyName, String jobType, String startDate, String endDate, ArrayList<String> descriptions) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobType = jobType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.descriptions = descriptions;
    }

    /**
     * The accessor for jobTitle.
     */
    public String getJobTitle() {
        return this.jobTitle;
    }

    /**
     * The mutator for jobTitle.
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * The accessor for companyName.
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * The mutator for companyName.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * The accessor for startDate
     */
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * The mutator for startDate.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * The accessor for endDate.
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * The mutator for endDate.
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * The accossor for jobType.
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * The mutator for jobType.
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * The accessor for jobDescription.
     */
    public ArrayList<String> getJobDescription() {
        return descriptions;
    }

    /**
     * The mutator for jobDescription.
     */
    public void setJobDescription(ArrayList<String> descriptions) {
        this.descriptions = descriptions;
    }
    
    /**
     * The method that returns a String with each variable concatenated to it.
     */
    public String toString() {
        String string =
            jobTitle + "\n" +
            "\t" + companyName + "\n" +
            "\t" + jobType + "\n" +
            "\t" + startDate + " - " + endDate;
        for(int i = 0; i < descriptions.size(); i++) {
            string += "\n\t" + descriptions.get(i);
        }
        return string;
    }

}
