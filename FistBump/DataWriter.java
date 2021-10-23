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
    
    public static JSONObject createAdmin(String name, String email, String password){
        Admin admin = new Admin(name, email, password);
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("id", admin.id);
        map.put("name", admin.name);
        map.put("email", admin.email);
        map.put("password", admin.password);

        JSONObject obj = new JSONObject(map);
        return obj;
    }
//TODO Fix how JSONs are formatted into one line
    public static void writeAdmin(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Admin.json")){
            
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
        System.out.println(obj);
    }

    public static JSONObject createEmployer(String name, String email, String password){
        Employer employer = new Employer(name, email, password);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id", employer.id);
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

    public static void writeEmployer(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Employer.json")){
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
        System.out.println(obj);
    }

    public static JSONObject createInternship(){
        //TODO fix this shit with employer
        Employer employer = new Employer("", "", "");
        Internship internship = new Internship(employer);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("id", internship.id);
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

    public static void writeInternship(JSONArray obj){
        try(FileWriter file = new FileWriter("FistBump\\Internship.json")){
            file.write(obj.toJSONString());
            file.flush();
        }
        catch(IOException e){e.printStackTrace();}
        System.out.println(obj);
    }

//TODO delete main
    public static void main(String[] args){
        JSONArray array = new JSONArray();

        JSONObject obj1 = createAdmin("Brian", "brian01white@gmail.com", "password");
        JSONObject obj2 = createAdmin("Kyle", "betteremail@mspaint.gov", "betterPassword");

        array.add(array.size(), obj1);
        array.add(array.size(), obj2);
        
        writeAdmin(array);
//To get a key value from an object in the JSON Array, you mush typecast the array to a hashmap
        System.out.println(((HashMap) array.get(0)).get("name"));
    }

}





























/**
     * There may be some stuff missing here for the final implementation,
     * I don't really know how a data writer should work, whether or not there should
     * be a scanner etc. Refer to the TriviaGame assignment and @portiaportia's DataWriter
     * for implementation guidance
     *


    //Not all of these may be necessary, I figure we need one method per JSON file we're writing to
    public void saveAccounts() {
        //TODO
    }

    public void saveResumes() {
        //TODO
    }

    public void saveInternships() {
        //TODO
    }

    public void saveRatings() {
        //TODO this one especially may not be necessary if we keep ratings contained within the
        //Account's JSON file somehow
    }
    */