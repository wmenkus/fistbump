/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.UUID;

public class Internship {
    private ArrayList<Student> applicants;
    private Employer poster;
    private String company;
    private String name;
    private String description;
    private double pay;
    private int timePeriod;
    private String skillRequirements;
    private boolean onSite;
    private boolean available;
    private StudentSortBehavior sortBehavior;
    private UUID id;
    private String startDate;
    private boolean visibility;

    public Internship(Employer poster) {
        this.applicants = new ArrayList<Student>();
        setPoster(poster);
        setCompany("");
        setName("");
        setDescription("");
        setPay(0);
        setTimePeriod(0);
        setSkillRequirements("");
        this.id = UUID.randomUUID();
        setStartDate("");
        setVisibility(true);
    }

    //TODO check if this is correct from strategy design pattern
    public void setSortMode(String sortMode) {
        if(sortMode.equalsIgnoreCase("GPA")) {
            sortBehavior = new GPASort();
        }
    }

    public void sort() {
        //TODO
    }

    public void addStudent(Student student) {
        applicants.add(student);
    }

    public Employer getPoster() {
        return this.poster;
    }

    public void setPoster(Employer poster) {
        this.poster = poster;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPay() {
        return this.pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public int getTimePeriod() {
        return this.timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getSkillRequirements() {
        return this.skillRequirements;
    }

    public void setSkillRequirements(String skillRequirements) {
        this.skillRequirements = skillRequirements;
    }

    public boolean isOnSite() {
        return this.onSite;
    }

    public void setOnSite(boolean onSite) {
        this.onSite = onSite;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean getVisibility() {
        return this.visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

}