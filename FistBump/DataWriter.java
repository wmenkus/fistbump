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
            map.put("id", admin.id.toString());
            map.put("name", admin.name);
            map.put("email", admin.email);
            map.put("password", admin.password);

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
            map.put("company", employer.getCompany());
            map.put("bio", employer.getBio());
            JSONArray internships = new JSONArray();
            internships = (JSONArray) employer.getInternships();
            map.put("internships", internships);
            JSONArray ratings = new JSONArray();
            ratings = (JSONArray) employer.getRatings();
            map.put("ratings", ratings);

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
                HashMap<String, String> map2 = new HashMap<String, String>();

                map2.put("resume", resume.toString());
                JSONObject resumeObj = new JSONObject(map);
                resumeArray.add(resumeObj);
            }


            map.put("resumes", resumes);

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

            JSONArray applicants = new JSONArray();
            applicants = (JSONArray) internship.getApplicants();
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


//TODO delete main
public static void main(String[] args) {
        
        Employment employment1 = new Employment("jobTitle", "companyName", "startDate", "endDate", "contactInfo");

        ArrayList<Employment> employmentList = new ArrayList<Employment>();
        employmentList.add(employment1);

        Education education1 = new Education("institution", "location", "degree", "graduationDate");

        ArrayList<Education> educationList = new ArrayList<Education>();
        educationList.add(education1);

        Resume resume1 = new Resume("skills", "references", 2.5, employmentList, educationList);
        Resume resume2 = new Resume("skills", "references", 2.5, employmentList, educationList);

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