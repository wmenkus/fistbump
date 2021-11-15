/**
 * @author Brian White
 */

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

public class DataLoader {

    /**
     * Creates an Admin array list and fills it with Admin objects created using objects stored in Admin.json
     */
    public static ArrayList<Admin> loadAdmins() {

        ArrayList<Admin> admins = new ArrayList<Admin>();

        JSONParser parser = new JSONParser();

        try {

            JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Admin.json"));

            for (Object obj : array) {
                JSONObject adminObj = (JSONObject) obj;

                String name = (String) adminObj.get("name");
                String email = (String) adminObj.get("email");
                UUID id;
                id = UUID.fromString((String) adminObj.get("id"));
                String password = (String) adminObj.get("password");

                Admin admin = new Admin(id, name, email, password);

                admins.add(admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return admins;
    }
    
    /**
     * Creates an Employer array list and fills it with Employer objects created using objects stored in Employer.json
     */
    public static ArrayList<Employer> loadEmployers() {

        ArrayList<Employer> employers = new ArrayList<Employer>();

        JSONParser parser = new JSONParser();

        try {

            JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Employer.json"));

            for (Object obj : array) {
                JSONObject employerObj = (JSONObject) obj;

                String name = (String) employerObj.get("name");
                String email = (String) employerObj.get("email");
                UUID id;
                id = UUID.fromString((String) employerObj.get("id"));
                String password = (String) employerObj.get("password");
                String bio = (String) employerObj.get("bio");

                ArrayList<String> internshipIds = new ArrayList<String>();
                JSONArray internshipList = (JSONArray) employerObj.get("internshipIds");

                for (Object obj2 : internshipList) {
                    JSONObject internshipIdObj = (JSONObject) obj2;
                    String internshipId = internshipIdObj.get("internshipId").toString();
                    internshipIds.add(internshipId);
                }

                ArrayList<Rating> ratings = new ArrayList<Rating>();
                ArrayList<Student> allStudents = loadStudentsNoRatings();
                JSONArray ratingList = (JSONArray) employerObj.get("ratings");

                for (Object rating : ratingList) {
                    JSONObject ratingObj = (JSONObject) rating;

                    double ratingNum = (double) ratingObj.get("rating");
                    Student rater = null;
                    for (Student student : allStudents) {
                        if (student.getId().toString().equals(ratingObj.get("raterId"))) {
                            rater = student;
                        }
                    }
                    boolean valid = (boolean) ratingObj.get("valid");

                    ratings.add(new Rating(ratingNum, rater, valid));
                }

                Employer employer = new Employer(id, name, email, password, bio, internshipIds, ratings);

                employers.add(employer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employers;
    }
    
    
    public static ArrayList<Employer> loadEmployersNoRatings() {

        ArrayList<Employer> employers = new ArrayList<Employer>();

        JSONParser parser = new JSONParser();

        try {

            JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Employer.json"));

            for (Object obj : array) {
                JSONObject employerObj = (JSONObject) obj;

                String name = (String) employerObj.get("name");
                String email = (String) employerObj.get("email");
                UUID id;
                id = UUID.fromString((String) employerObj.get("id"));
                String password = (String) employerObj.get("password");
                String bio = (String) employerObj.get("bio");
                
                ArrayList<String> internshipIds = new ArrayList<String>();
                JSONArray internshipList = new JSONArray();
                for (Object internshipIdObj : internshipList) {
                    String internshipId = (String) internshipIdObj;
                    internshipIds.add(internshipId);
                }

                Employer employer = new Employer(id, name, email, password, bio, internshipIds);

                employers.add(employer);
            }
        } 
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace();}
        catch (Exception e) {e.printStackTrace();}

        return employers;
    }
    
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<Student>();

        JSONParser parser = new JSONParser();
    
    try{

        JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Student.json"));

        for (Object obj : array)
        {
            JSONObject studentObj = (JSONObject) obj;
            
            UUID id;
            id = UUID.fromString((String) studentObj.get("id"));
            String name = (String) studentObj.get("name");
            String email = (String) studentObj.get("email");
            String password = (String) studentObj.get("password");
            String phoneNumber = (String) studentObj.get("phoneNumber");

            ArrayList<Resume> resumes = new ArrayList<Resume>();
            JSONArray resumeList = (JSONArray) studentObj.get("resumes");

            for (Object resume : resumeList) {
                JSONObject resumeObj = (JSONObject) resume;

                String skills = (String) resumeObj.get("skills");
                double gpa = (double) resumeObj.get("gpa");

                ArrayList<Employment> pastEmployment = new ArrayList<Employment>();
                JSONArray employmentList = (JSONArray) resumeObj.get("pastEmployment");

                for (Object employment : employmentList) {
                    JSONObject employmentObj = (JSONObject) employment;

                    String jobTitle = (String) employmentObj.get("jobTitle");
                    String companyName = (String) employmentObj.get("companyName");
                    String jobType = (String) employmentObj.get("jobType");
                    String startDate = (String) employmentObj.get("startDate");
                    String endDate = (String) employmentObj.get("endDate");

                    ArrayList<String> descriptions = new ArrayList<String>();
                    JSONArray descriptionList = (JSONArray) employmentObj.get("descriptions");
                    for (Object descriptionObj : descriptionList) {
                        JSONObject jsonDescription = (JSONObject) descriptionObj;
                        descriptions.add((String) jsonDescription.get("jobDescription"));
                    }
                    pastEmployment.add(new Employment(jobTitle, companyName, jobType, startDate, endDate, descriptions));
                }
                
                ArrayList<Education> educations = new ArrayList<Education>();
                JSONArray educationList = (JSONArray) resumeObj.get("education");

                for (Object education : educationList) {
                    JSONObject educationObj = (JSONObject) education;

                    String institution = (String) educationObj.get("institution");
                    String degree = (String) educationObj.get("degree");
                    String graduationDate = (String) educationObj.get("graduationDate");

                    educations.add(new Education(institution, degree, graduationDate));
                }
                resumes.add(new Resume(skills, gpa, pastEmployment, educations));
            }


            ArrayList<Rating> ratings = new ArrayList<Rating>();
            ArrayList<Employer> allEmployers = loadEmployersNoRatings();
            JSONArray ratingList = (JSONArray) studentObj.get("ratings");

            for (Object rating : ratingList) {
                JSONObject ratingObj = (JSONObject) rating;

                double ratingNum = (double) ratingObj.get("rating");
                Employer rater = null;
                for (Employer employer : allEmployers) {
                    if (employer.getId().toString().equals(ratingObj.get("raterId"))) {
                        rater = employer;
                    }
                }
                boolean valid = (boolean) ratingObj.get("valid");

                ratings.add(new Rating(ratingNum, rater, valid));
            }

            Student student = new Student(id, name, email, password, resumes, ratings, phoneNumber);

            students.add(student);
        }
    }
    catch (FileNotFoundException e) {e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    catch (Exception e) {e.printStackTrace();}
    
    return students;
    }
    
    public static ArrayList<Student> loadStudentsNoRatings() {

        ArrayList<Student> students = new ArrayList<Student>();

        JSONParser parser = new JSONParser();
    
    try{

        JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Student.json"));

        for (Object obj : array)
        {
            JSONObject studentObj = (JSONObject) obj;
            
            UUID id;
            id = UUID.fromString((String) studentObj.get("id"));
            String name = (String) studentObj.get("name");
            String email = (String) studentObj.get("email");
            String password = (String) studentObj.get("password");
            String phoneNumber = (String) studentObj.get("phoneNumber");

            ArrayList<Resume> resumes = new ArrayList<Resume>();
            JSONArray resumeList = (JSONArray) studentObj.get("resumes");

            for (Object resume : resumeList) {
                JSONObject resumeObj = (JSONObject) resume;

                String skills = (String) resumeObj.get("skills");
                double gpa = (double) resumeObj.get("gpa");

                ArrayList<Employment> pastEmployment = new ArrayList<Employment>();
                JSONArray employmentList = (JSONArray) resumeObj.get("pastEmployment");

                for (Object employment : employmentList) {
                    JSONObject employmentObj = (JSONObject) employment;

                    String jobTitle = (String) employmentObj.get("jobTitle");
                    String companyName = (String) employmentObj.get("companyName");
                    String jobType = (String) employmentObj.get("jobType");
                    String startDate = (String) employmentObj.get("startDate");
                    String endDate = (String) employmentObj.get("endDate");
                    
                    ArrayList<String> descriptions = new ArrayList<String>();
                    JSONArray descriptionList = (JSONArray) employmentObj.get("descriptions");
                    for (Object descriptionObj : descriptionList) {
                        JSONObject jsonDescription = (JSONObject) descriptionObj;
                        descriptions.add((String) jsonDescription.get("jobDescription"));
                    }
                    pastEmployment.add(new Employment(jobTitle, companyName, jobType, startDate, endDate, descriptions));
                }
                
               ArrayList<Education> educations = new ArrayList<Education>();
                JSONArray educationList = (JSONArray) resumeObj.get("education");

                for (Object education : educationList) {
                    JSONObject educationObj = (JSONObject) education;

                    String institution = (String) educationObj.get("institution");
                    String degree = (String) educationObj.get("degree");
                    String graduationDate = (String) educationObj.get("graduationDate");

                    educations.add(new Education(institution, degree, graduationDate));
                }
                resumes.add(new Resume(skills, gpa, pastEmployment, educations));
            }

            Student student = new Student(id, name, email, password, resumes, phoneNumber);

            students.add(student);
        }
    }
    catch (FileNotFoundException e) {e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    catch (Exception e) {e.printStackTrace();}
    
    return students;
    }
    
    public static ArrayList<Internship> loadInternships(){

        ArrayList<Internship> internships = new ArrayList<Internship>();

        JSONParser parser = new JSONParser();
    
    try{

        JSONArray array = (JSONArray) parser.parse(new FileReader("FistBump\\Internship.json"));

        for (Object obj : array)
        {
            JSONObject internshipObj = (JSONObject) obj;

            ArrayList<String> applicantIds = new ArrayList<String>();
            JSONArray applicantArray = (JSONArray) internshipObj.get("applicantIds");

            for (Object applicantObj : applicantArray) {

                JSONObject jApplicantObj = (JSONObject) applicantObj;
                String applicantId = jApplicantObj.get("applicantId").toString();
                applicantIds.add(applicantId);
            }
            
            String company = (String) internshipObj.get("company");
            String name = (String) internshipObj.get("name");
            String description = (String) internshipObj.get("description");
            double pay = (double) internshipObj.get("pay");
            int timePeriod = ((Long)internshipObj.get("timePeriod")).intValue();
            String skillRequirements = (String) internshipObj.get("skillRequirements");
            boolean onSite = (boolean) internshipObj.get("onSite");
            boolean available = (boolean) internshipObj.get("available");
            UUID id;
            id = UUID.fromString((String) internshipObj.get("id"));
            String startDate = (String) internshipObj.get("startDate");

            Internship internship = new Internship(applicantIds, company, name, description, pay, timePeriod, skillRequirements, onSite, available, id, startDate);

            internships.add(internship);
        }
    }
    catch (FileNotFoundException e) {e.printStackTrace();}
    catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    catch (Exception e) {e.printStackTrace();}
    
    return internships;
    }
}