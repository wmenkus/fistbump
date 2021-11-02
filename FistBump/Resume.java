/**
 * @author Jaden Heinle
 */

package FistBump;
        
import java.util.ArrayList;

public class Resume {
    private String skills;
    private double gpa;
    private ArrayList<Employment> pastEmployment;
    private ArrayList<Education> education;

    public Resume(Student student) {
        skills = "none";
        gpa = 0;
        pastEmployment = new ArrayList<Employment>();
        education = new ArrayList<Education>();
    }
    
    public Resume(String skills, double gpa, ArrayList<Employment> pastEmployment, ArrayList<Education> education) {
        this.skills = skills;
        this.gpa = gpa;
        this.pastEmployment = pastEmployment;
        this.education = education;
    }

    public String getSkills(){
        return this.skills;
    }

    public double getGpa(){
        return this.gpa;
    }

    public ArrayList<Employment> getPastEmployment(){
        return this.pastEmployment;
    }

    public ArrayList<Education> getEducation(){
        return this.education;
    }

    public void setSkills(String skills){
        this.skills = skills;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public void addPastEmployment(Employment pe){
        pastEmployment.add(pe);
    }

    public void addEducation(Education ed){
        education.add(ed);
    }

}
