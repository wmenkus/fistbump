/**
 * @author Jaden Heinle
 */

package FistBump;
        
import java.util.ArrayList;
import java.util.UUID;
public class Resume {
    private String skills;
    private String references;
    private double gpa;
    private ArrayList<Employment> pastEmployment;
    private ArrayList<Education> education;
    private ArrayList<UUID> skills;
    private ArrayList<UUID> reference;
    private UUID studentID;
    private UUID ID;

    public Resume(Student student){
        
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
