/**
 * @author Jaden Heinle
 */

package FistBump;

public class Education {
    private String institution;
    private String location;
    private String degree;
    private String graduationDate;

    public Education(){
        institution = "";
        location = "";
        degree = "";
        graduationDate = "";
    }
    public Education(String institution, String location, String degree, String graduationDate) {
        this.institution = institution;
        this.location = location;
        this.degree = degree;
        this.graduationDate = graduationDate;
    }
    public String getInstitution() {
        return this.institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public String getLocation() {
        return this.location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDegree() {
        return this.degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getGraduationDate() {
        return this.graduationDate;
    }
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }
}
