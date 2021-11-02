/**
 * The applicant's education   
 * @author Jaden Heinle
 */

package FistBump;

public class Education {
    private String institution;
    private String degree;
    private String graduationDate;

    /**
     * The default constructor for Education.
     * institution, degree and graduationDate are all set to an empty string.
     */
    public Education(){
        institution = "";
        degree = "";
        graduationDate = "";
    }

    /**
     * The parameterized constructor for Education.
     * this.institution is initialized as institution.
     * this.degree is initialized as degree.
     * this.graduationDate is initialized as graduationDate.
     */
    public Education(String institution, String degree, String graduationDate) {
        this.institution = institution;
        this.degree = degree;
        this.graduationDate = graduationDate;
    }

    /**
     * The accessor for institution.
     */
    public String getInstitution() {
        return this.institution;
    }

    /**
     * The mutator for institution.
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * 
     * @return
     */
    public String getDegree() {
        return this.degree;
    }

    /**
     * 
     * @param degree
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * 
     * @return
     */
    public String getGraduationDate() {
        return this.graduationDate;
    }

    /**
     * 
     * @param graduationDate
     */
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * 
     */
    public String toString() {
        return institution + "\n" +
        degree + "\n" +
        graduationDate;
    }
}
