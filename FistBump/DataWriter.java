/**
 * @author Brian White
 */

package FistBump;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

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

            JSONArray resumes = new JSONArray();
            resumes = (JSONArray) student.getResumes();
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
        
        Admin admin1 = new Admin("Brian", "brian01white@gmail.com", "password");
        Admin admin2 = new Admin("Kyle", "betteremail@mspaint.gov", "betterPassword");
        
        ArrayList<Admin> admins = new ArrayList<Admin>();

        admins.add(admin1);
        admins.add(admin2);

        saveAdmin(admins);
    }

}