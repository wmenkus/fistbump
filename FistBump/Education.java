/**
 * @author Jaden Heinle
 */

package FistBump;

public class Education {
    private String institution;
    private String degree;
    private String graduationDate;

    public Education(){
        institution = "";
        degree = "";
        graduationDate = "";
    }
    public Education(String institution, String degree, String graduationDate) {
        this.institution = institution;
        this.degree = degree;
        this.graduationDate = graduationDate;
    }
    public String getInstitution() {
        return this.institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
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

    public String toString() {
        return institution + "\n" +
        degree + "\n" +
        graduationDate;
    }
}
