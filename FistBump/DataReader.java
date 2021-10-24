package FistBump;

import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    public ArrayList<Admin> loadAdmins() {

        ArrayList<Admin> admins = new ArrayList<Admin>();

        JSONParser parser = new JSONParser();
    
    try{

        JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Admin.json"));

        for (Object obj : array)
        {
            JSONObject adminObj = (JSONObject) obj;

            String name = (String) adminObj.get("name");
            String email = (String) adminObj.get("email");
            UUID id = (UUID) adminObj.get("id");
            String password = (String) adminObj.get("password");

            Admin admin = new Admin(id, name, email, password);

            admins.add(admin);
        }
    }
    catch (FileNotFoundException e) {e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    catch (Exception e) {e.printStackTrace();}
    
    return admins;
    }
    
    public ArrayList<Employer> loadEmployers() {

        ArrayList<Employer> employers = new ArrayList<Employer>();

        JSONParser parser = new JSONParser();

        try {

            JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Employer.json"));

            for (Object obj : array) {
                JSONObject employerObj = (JSONObject) obj;

                String name = (String) employerObj.get("name");
                String email = (String) employerObj.get("email");
                UUID id = (UUID) employerObj.get("id");
                String password = (String) employerObj.get("password");
                String company = (String) employerObj.get("company");
                String bio = (String) employerObj.get("bio");
                ArrayList<Internship> internships = (ArrayList<Internship>) employerObj.get("internships");
                ArrayList<Rating> ratings = (ArrayList<Rating>) employerObj.get("ratings");

                Employer employer = new Employer(id, name, email, password, company, bio, internships, ratings);

                employers.add(employer);
            }
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

        return employers;
    }
    
    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<Student>();

        JSONParser parser = new JSONParser();
    
    try{

        JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Student.json"));

        for (Object obj : array)
        {
            JSONObject studentObj = (JSONObject) obj;
            
            UUID id = (UUID) studentObj.get("id");
            String name = (String) studentObj.get("name");
            String email = (String) studentObj.get("email");
            String password = (String) studentObj.get("password");
            ArrayList<Resume> resumes = (ArrayList<Resume>) studentObj.get("resumes");
            ArrayList<Rating> ratings = (ArrayList<Rating>) studentObj.get("ratings");

            Student student = new Student(id, name, email, password, resumes, ratings);

            students.add(student);
        }
    }
    catch (FileNotFoundException e) {e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    catch (Exception e) {e.printStackTrace();}
    
    return students;
    }
    
    public ArrayList<Internship> loadInternships(){
        return null;
    }
}
