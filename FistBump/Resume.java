/**
 * @author Jaden Heinle
 */

package FistBump;
        
import java.util.ArrayList;

public class Resume {
    private String skills;
    private String references;
    private double gpa;
    private ArrayList<Employment> pastEmployment;
    private ArrayList<Education> education;

    public Resume(Student student) {
        skills = "none";
        references = "none";
        gpa = 0;
        pastEmployment = new ArrayList<Employment>();
        education = new ArrayList<Education>();
    }
    
    public Resume(String skills, String references, double gpa, ArrayList<Employment> pastEmployment, ArrayList<Education> education) {
        this.skills = skills;
        this.references = references;
        this.gpa = gpa;
        this.pastEmployment = pastEmployment;
        this.education = education;
    }

    public Resume(double gpa){
        skills = "";
        references = "";
        this.gpa = gpa;
        pastEmployment = new ArrayList<Employment>();
        education = new ArrayList<Education>();
    }

    public String getSkills(){
        return this.skills;
    }

    public String getReferences(){
        return this.references;
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

    public void setSkills(){

    }

    public void setReferences(){
        
    }

    public void setGpa(){

    }

    public void addPastEmployment(){

    }

    public void addEducation(){

    }

}
