/**
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

    public Employment() {
        jobTitle = "";
        companyName = "";
        jobType = "";
        startDate = "";
        endDate = "";
        descriptions = new ArrayList<String>();
        
    }

    public Employment(String jobTitle, String companyName, String jobType, String startDate, String endDate, ArrayList<String> descriptions) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobType = jobType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.descriptions = descriptions;
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

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }
    
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
