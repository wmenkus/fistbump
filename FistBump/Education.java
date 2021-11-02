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
     * The default constructor for education.
     * Insitution, degree, and graduationDate are all set to empty strings.
     */
    public Education(){
        institution = "";
        degree = "";
        graduationDate = "";
    }
    
    /**
     * The parameterized constructor for education.
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
     * The accessor for degree.
     */
    public String getDegree() {
        return this.degree;
    }
    
    /**
     * The mutator for degree.
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    /**
     * The accessor for graduationDate.
     */
    public String getGraduationDate() {
        return this.graduationDate;
    }
    
    /**
     * The mutator for graduationDate.
     */
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * The method that returns a String with each variable concatenated to it.
     */
    public String toString() {
        return institution + "\n" +
        degree + "\n" +
        graduationDate;
    }
}
