package FistBump;
import java.util.ArrayList;

public class GPASort implements StudentSortBehavior {
    public void sort(ArrayList<Student> students) {

    }
    private int partition (ArrayList<Student> students, int low, int high) {
        // pivot (Element to be placed at right position)
        //I am so sorry.
        double pivot = getGpa(students.get(high));
        int i = (low - 1);  // Index of smaller element and indicates the 
                    // right position of pivot found so far

        for (int j = low; j <= high - 1; j++)
        {
            // If current element is smaller than the pivot
            if (getGpa(students.get(j)) < pivot)
            {
                i++;    // increment index of smaller element
                //swap arr[i] and arr[j]
                Student temp = students.get(j);
                students.set(j, students.get(i));
                students.set(i, temp);
            }
        }
        //swap arr[i + 1] and arr[high])
        Student temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);
        return i + 1;
    }

    private double getGpa(Student student) {
        return student.getResumes().get(student.getResumes().size() - 1).getGpa();
    }

    public static void main(String[] args) {
        
    }

}
