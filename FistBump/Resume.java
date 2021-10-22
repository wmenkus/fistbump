/**
 * @author Jaden Heinle
 */

package FistBump;

<<<<<<< HEAD
public class Resume {
    private ArrayList<UUID> skills;
    private ArrayList<UUID> reference;
    private double gpa;
    private ArrayList<Employment> pastEmployment;
    private ArrayList<Education> education;
    private UUID studentID;
    private UUID ID;

    public Resume(Student student){
        
=======
import java.util.ArrayList;

public class Resume {
    private String skills;
    private String references;
    private double gpa;
    private ArrayList<Employment> pastEmployment;
    private ArrayList<Education> education;

    public Resume(double gpa){
        skills = "";
        references = "";
        this.gpa = gpa;
        pastEmployment = new ArrayList<Employment>();
        education = new ArrayList<Education>();
>>>>>>> 86297744fb9e6bc8151e69693b409e963cc25f06
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
