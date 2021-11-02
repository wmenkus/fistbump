/**
 * @author Brian White
 */

package FistBump;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    
    public static void saveAdmin(ArrayList<Admin> admins) {
        
        JSONArray array = new JSONArray();

        for (Admin admin : admins) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id", admin.getId().toString());
            map.put("name", admin.getName());
            map.put("email", admin.getEmail());
            map.put("password", admin.getPassword());

            JSONObject obj = new JSONObject(map);
            array.add(array.size(), obj);
        }

        try(FileWriter file = new FileWriter("FistBump\\Admin.json")){
            file.write(array.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }

    public static void saveEmployer(ArrayList<Employer> employers) {

        JSONArray array = new JSONArray();

        for (Employer employer : employers) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", employer.id.toString());
            map.put("name", employer.name);
            map.put("email", employer.email);
            map.put("password", employer.password);
            map.put("bio", employer.getBio());

            JSONArray internshipArray = new JSONArray(); 
            ArrayList<Internship> internships = employer.getInternships();
            for (Internship internship : internships) {
                HashMap<String, String> internshipMap = new HashMap<String, String>();

                internshipMap.put("internshipId", internship.getId().toString());

                JSONObject internshipObj = new JSONObject(map);
                internshipArray.add(internshipObj);
            }
            map.put("internships", internshipArray);

            JSONArray ratingArray = new JSONArray(); 
            ArrayList<Rating> ratings = employer.getRatings();
            for (Rating rating : ratings) {
                HashMap<String, Object> ratingMap = new HashMap<String, Object>();

                ratingMap.put("raterId", rating.getRater().getId().toString());
                ratingMap.put("ratedId", rating.getRated().getId().toString());
                ratingMap.put("rating", rating.getRating());
                ratingMap.put("valid", rating.isValid());

                JSONObject ratingObj = new JSONObject(map);
                ratingArray.add(ratingObj);
            }
            map.put("ratings", ratingArray);

            JSONObject obj = new JSONObject(map);
            array.add(array.size(), obj);
        }

        try (FileWriter file = new FileWriter("FistBump\\Employer.json")) {
            file.write(array.toJSONString());
            file.flush();
        } catch (IOException e) {e.printStackTrace();}
    }
    

    public static void saveStudent(ArrayList<Student> students) {
        
        JSONArray array = new JSONArray();

        for (Student student : students) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", student.id.toString());
            map.put("name", student.name);
            map.put("email", student.email);
            map.put("password", student.password);

            JSONArray resumeArray = new JSONArray(); 
            ArrayList<Resume> resumes = student.getResumes();

            for (Resume resume : resumes) {
                HashMap<String, Object> resumeMap = new HashMap<String, Object>();

                resumeMap.put("skills", resume.getSkills());
                resumeMap.put("gpa", resume.getGpa());

                JSONArray employmentArray = new JSONArray();
                ArrayList<Employment> pastEmployment = resume.getPastEmployment();

                for (Employment employment : pastEmployment) {
                    HashMap<String, Object> employmentMap = new HashMap<String, Object>();

                    employmentMap.put("jobTitle", employment.getJobTitle());
                    employmentMap.put("companyName", employment.getCompanyName());
                    employmentMap.put("jobType", employment.getJobType());
                    employmentMap.put("startDate", employment.getStartDate());
                    employmentMap.put("endDate", employment.getEndDate());
                    employmentMap.put("jobDescription", employment.getJobDescription());

                    JSONObject employmentObj = new JSONObject(employmentMap);
                    employmentArray.add(employmentObj);
                }
                resumeMap.put("pastEmployment", employmentArray);
                
                JSONArray educationArray = new JSONArray();
                ArrayList<Education> educationList = resume.getEducation();

                for (Education education : educationList) {
                    HashMap<String, Object> educationMap = new HashMap<String, Object>();

                    educationMap.put("institution", education.getInstitution());
                    educationMap.put("location", education.getLocation());
                    educationMap.put("degree", education.getDegree());
                    educationMap.put("graduationDate", education.getGraduationDate());

                    JSONObject educationObj = new JSONObject(educationMap);
                    educationArray.add(educationObj);
                }
                resumeMap.put("education", educationArray);

                JSONObject resumeObj = new JSONObject(resumeMap);
                resumeArray.add(resumeObj);
            }
            map.put("resumes", resumeArray);


            JSONArray ratingArray = new JSONArray(); 
            ArrayList<Rating> ratings = student.getRatings();
            for (Rating rating : ratings) {
                HashMap<String, Object> ratingMap = new HashMap<String, Object>();

                ratingMap.put("raterId", rating.getRater().getId().toString());
                ratingMap.put("ratedId", rating.getRated().getId().toString());
                ratingMap.put("rating", rating.getRating());
                ratingMap.put("valid", rating.isValid());

                JSONObject ratingObj = new JSONObject(map);
                ratingArray.add(ratingObj);
            }
            map.put("ratings", ratingArray);

            JSONObject obj = new JSONObject(map);
            array.add(array.size(), obj);
        }

        try(FileWriter file = new FileWriter("FistBump\\Student.json")){
            
            file.write(array.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }

    public static void saveInternship(ArrayList<Internship> internships) {

        JSONArray array = new JSONArray();
        
        for (Internship internship : internships) {
            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("id", internship.id.toString());
            map.put("poster", internship.getPoster());
            map.put("company", internship.getCompany());
            map.put("name", internship.getName());
            map.put("description", internship.getDescription());
            map.put("pay", internship.getPay());
            map.put("timePeriod", internship.getTimePeriod());
            map.put("skillRequirements", internship.getSkillRequirements());
            map.put("onSite", internship.isOnSite());
            map.put("available", internship.isAvailable());
            map.put("startDate", internship.getStartDate());
            map.put("visibility", internship.isVisible());
            map.put("sortBehavior", internship.getSortBehavior());

            JSONArray ratingArray = new JSONArray(); 
            ArrayList<Student> applicants = internship.getApplicants();
            for (Student applicant : applicants) {
                HashMap<String, String> applicantMap = new HashMap<String, String>();

                applicantMap.put("applicantId", applicant.getId().toString());
                JSONObject applicantObj = new JSONObject(applicantMap);
                ratingArray.add(applicantObj);
            }
            map.put("applicants", applicants);

            JSONObject obj = new JSONObject(map);
            array.add(array.size(), obj);
        }

        try(FileWriter file = new FileWriter("FistBump\\Internship.json")){
            file.write(array.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }
    
    public static void saveResume(Resume resume) {
        
    }


//TODO delete main
public static void main(String[] args) {
        
        Employment employment1 = new Employment("jobTitle", "companyName", "jobType", "startDate", "endDate", "jobDescription");

        ArrayList<Employment> employmentList = new ArrayList<Employment>();
        employmentList.add(employment1);

        Education education1 = new Education("institution", "location", "degree", "graduationDate");

        ArrayList<Education> educationList = new ArrayList<Education>();
        educationList.add(education1);

        Resume resume1 = new Resume("skills", 2.5, employmentList, educationList);
        Resume resume2 = new Resume("skills", 2.5, employmentList, educationList);

        ArrayList<Resume> resumeList = new ArrayList<Resume>();
        resumeList.add(resume1);
        resumeList.add(resume2);
        

        Student student1 = new Student("Brian", "brian01white@gmail.com", "password", resumeList);
        Student student2 = new Student("Kyle", "betteremail@mspaint.gov", "betterPassword", resumeList);

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(student1);
        students.add(student2);

        saveStudent(students);

        System.out.println(resume1.toString());
    }

}