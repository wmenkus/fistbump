/**
 * @author Brian White
 */

package FistBump;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
public class DataWriter {
    
    public static JSONObject createAdmin(Admin admin){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", admin.id.toString());
        map.put("name", admin.name);
        map.put("email", admin.email);
        map.put("password", admin.password);

        JSONObject obj = new JSONObject(map);
        return obj;
    }

    public static void saveAdmin(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Admin.json")){
            
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }

    public static JSONObject createEmployer(Employer employer){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id", employer.id.toString());
        map.put("name", employer.name);
        map.put("email", employer.email);
        map.put("password", employer.password);
        map.put("company", employer.getCompany());
        map.put("bio", employer.getBio());
        JSONArray internships = new JSONArray();
        internships = (JSONArray)employer.getInternships();
        map.put("internships", internships);
        JSONArray ratings = new JSONArray();
        ratings = (JSONArray)employer.getRatings();
        map.put("ratings", ratings);
        
        JSONObject obj = new JSONObject(map);

        return obj;
    }

    public static void saveEmployer(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Employer.json")){
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }

    public static JSONObject createSutdent(Student student){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id", student.id.toString());
        map.put("name", student.name);
        map.put("email", student.email);
        map.put("password", student.password);

        JSONArray resumes = new JSONArray();
        resumes = (JSONArray)student.getResumes();
        map.put("resumes", resumes);

        JSONObject obj = new JSONObject(map);
        return obj;
    }

    public static void saveStudent(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Student.json")){
            
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }

    public static JSONObject createInternship(Internship internship){
        HashMap<String,Object> map = new HashMap<String,Object>();
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
        //map.put("visibility", internship.isVisible())//TODO Add isVisible
        JSONArray applicants = new JSONArray();
        //applicants = (JSONArray)internship.getApplcants();//TODO Add getApplicants
        map.put("applicants", applicants);

    //private StudentSortBehavior sortBehavior;
    
        JSONObject obj = new JSONObject(map);

        return obj;
    }

    public static void saInternship(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Internship.json")){
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
    }

//TODO delete main
    public static void main(String[] args){
        JSONArray array = new JSONArray();
        Admin admin1 = new Admin("Brian", "brian01white@gmail.com", "password");
        Admin admin2 = new Admin("Kyle", "betteremail@mspaint.gov", "betterPassword");
        JSONObject obj1 = createAdmin(admin1);
        JSONObject obj2 = createAdmin(admin2);

        array.add(array.size(), obj1);
        array.add(array.size(), obj2);
        
        saveAdmin(array);
//To get a key value from an object in the JSON Array, you mush typecast the array to a hashmap
        System.out.println(((HashMap) array.get(0)).get("name"));
    }

}