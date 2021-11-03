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
import java.io.File;

public class DataWriter {

    /**
     * @param admins
     * Takes an array of admins and saves all of their variables to Admin.json so that the objects can be retrieved after the program is closed
     */
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

        try (FileWriter file = new FileWriter("FistBump\\Admin.json")) {
            file.write(array.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param employers
     * Takes an array of employers and saves all of their variables to Employer.json so that the objects can be retrieved after the program is closed
     */
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

                JSONObject internshipObj = new JSONObject(internshipMap);
                internshipArray.add(internshipObj);
            }
            map.put("internshipIds", internshipArray);

            JSONArray ratingArray = new JSONArray();
            ArrayList<Rating> ratings = employer.getRatings();
            for (Rating rating : ratings) {
                HashMap<String, Object> ratingMap = new HashMap<String, Object>();

                ratingMap.put("raterId", rating.getRater().getId().toString());
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param students
     * Takes an array of students and saves all of their variables, including their resumes, to Student.json so that the objects can be retrieved after the program is closed
     */
    public static void saveStudent(ArrayList<Student> students) {

        JSONArray array = new JSONArray();

        for (Student student : students) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("id", student.id.toString());
            map.put("name", student.name);
            map.put("email", student.email);
            map.put("password", student.password);
            map.put("phoneNumber", student.getPhoneNumber());

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

                    ArrayList<String> descriptions = employment.getDescriptions();
                    JSONArray descriptionList = new JSONArray();
                    for (String description : descriptions) {
                        HashMap<String, Object> descriptionMap = new HashMap<String, Object>();
                        descriptionMap.put("jobDescription", description);
                        JSONObject descriptionObj = new JSONObject(descriptionMap);
                        descriptionList.add(descriptionObj);
                    }
                    employmentMap.put("descriptions", descriptionList);

                    JSONObject employmentObj = new JSONObject(employmentMap);
                    employmentArray.add(employmentObj);
                }
                resumeMap.put("pastEmployment", employmentArray);

                JSONArray educationArray = new JSONArray();
                ArrayList<Education> educationList = resume.getEducation();

                for (Education education : educationList) {
                    HashMap<String, Object> educationMap = new HashMap<String, Object>();

                    educationMap.put("institution", education.getInstitution());
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
                ratingMap.put("rating", rating.getRating());
                ratingMap.put("valid", rating.isValid());

                JSONObject ratingObj = new JSONObject(map);
                ratingArray.add(ratingObj);
            }
            map.put("ratings", ratingArray);

            JSONObject obj = new JSONObject(map);
            array.add(array.size(), obj);
        }

        try (FileWriter file = new FileWriter("FistBump\\Student.json")) {

            file.write(array.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param internships
     * Takes an array of internships and saves all of their variables to Internship.json so that the objects can be retrieved after the program is closed
     */
    public static void saveInternship(ArrayList<Internship> internships) {

        JSONArray array = new JSONArray();

        for (Internship internship : internships) {
            HashMap<String, Object> map = new HashMap<String, Object>();

            map.put("id", internship.id.toString());
            map.put("posterId", internship.getPoster().id.toString());
            map.put("company", internship.getCompany());
            map.put("name", internship.getName());
            map.put("description", internship.getDescription());
            map.put("pay", internship.getPay());
            map.put("timePeriod", internship.getTimePeriod());
            map.put("skillRequirements", internship.getSkillRequirements());
            map.put("onSite", internship.isOnSite());
            map.put("available", internship.isAvailable());
            map.put("startDate", internship.getStartDate());

            JSONArray applicantArray = new JSONArray();
            ArrayList<Student> applicants = internship.getApplicants();
            for (Student applicant : applicants) {
                HashMap<String, String> applicantMap = new HashMap<String, String>();

                applicantMap.put("applicantId", applicant.getId().toString());
                JSONObject applicantObj = new JSONObject(applicantMap);
                applicantArray.add(applicantObj);
            }
            map.put("applicantIds", applicantArray);

            JSONObject obj = new JSONObject(map);
            array.add(array.size(), obj);
        }

        try (FileWriter file = new FileWriter("FistBump\\Internship.json")) {
            file.write(array.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *@param resume
     *Takes in a resume object and prints its toString to a text file named Resume.txt
     *
     */
    public static void saveResume(Resume resume) {

        File file = new File("FistBump\\Resume.txt");

        try {
            FileWriter fileWriter = new FileWriter("FistBump\\Resume.txt");
            fileWriter.write(resume.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

