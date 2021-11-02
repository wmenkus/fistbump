/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;
import java.util.UUID;

public class Internship {
    private ArrayList<Student> applicants;
    private ArrayList<String> applicantIds;
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
    protected UUID id;
    private String startDate;

    public Internship(Employer poster, String name, double pay, String description, int timePeriod, String skillRequirements, boolean onSite, String startDate) {
        this.id = UUID.randomUUID();
        this.poster = poster;
        this.company = poster.getName();
        this.name = name;
        this.pay = pay;
        this.description = description;
        this.timePeriod = timePeriod;
        this.skillRequirements = skillRequirements;
        this.onSite = onSite;
        this.startDate = startDate;
        this.available = true;
        this.sortBehavior = new RatingSort();
        applicants = new ArrayList<Student>();
        applicantIds = new ArrayList<String>();
    }

    public Internship(ArrayList<String> applicantIds, String company, String name, String description,
            double pay, int timePeriod, String skillRequirements, boolean onSite, boolean available, UUID id, String startDate) {
        this.applicantIds = applicantIds;
        this.applicants = new ArrayList<Student>();
        this.company = company;
        this.name = name;
        this.description = description;
        this.pay = pay;
        this.timePeriod = timePeriod;
        this.skillRequirements = skillRequirements;
        this.onSite = onSite;
        this.available = available;
        this.id = id;
        this.startDate = startDate;
    }

    public void sort() {
        sortBehavior.sort(applicants);
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

    public void setSortBehavior(String sortMode) {
        if(sortMode.equalsIgnoreCase("gpa")) {
            sortBehavior = new GPASort();
        }
        else if(sortMode.equalsIgnoreCase("rating")) {
            sortBehavior = new RatingSort();
        }
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public ArrayList<Student> getApplicants() {
        return applicants;
    }

    public StudentSortBehavior getSortBehavior() {
        return sortBehavior;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<String> getApplicantIds() {
        return applicantIds;
    }

    public void setApplicants(ArrayList<Student> applicants) {
        this.applicants = applicants;
    }

    public String toString() {
        return "\tJob title: " + name + "\n\tCompany: " + company +
        "\n\tPay: $" + pay + "per hour\n\tLength of internship: " + timePeriod + " months";
    }

    public String details(){
        String string = "";
        string += "Company: "+company;
        string += "\nJob Title: "+name;
        string += "\nDescription: "+description;
        string += "\nPay: $" + pay + "per hour";
        string += "\nStart Date: "+startDate;
        string += "\nTime Period: "+timePeriod+" months";
        string += "\nSkill Requirements: "+skillRequirements;
        string += "\nOn-Site: "+onSite;
        string += "\nAvailability: "+available;

        return string;
    }
}