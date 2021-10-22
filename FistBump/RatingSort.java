/**
 * @author Walker Menkus
 */

package FistBump;

import java.util.ArrayList;

/**
 * Uses an implementation of QuickSort pulled from the internet https://www.geeksforgeeks.org/quick-sort/
 */
public class RatingSort implements StudentSortBehavior {
    public void sort(ArrayList<Student> students) {
        quickSort(students, 0, students.size() - 1);
    }

    private void quickSort(ArrayList<Student> students, int low, int high) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now
            at right place */
            int pi = partition(students, low, high);

            quickSort(students, low, pi - 1);  // Before pi
            quickSort(students, pi + 1, high); // After pi
        }
    }

    private int partition (ArrayList<Student> students, int low, int high) {
        // pivot (Element to be placed at right position)
        double pivot = getRating(students.get(high));
        int i = (low - 1);  // Index of smaller element and indicates the 
                    // right position of pivot found so far

        for (int j = low; j <= high - 1; j++)
        {
            // If current element is smaller than the pivot
            if (getRating(students.get(j)) < pivot)
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

    private double getRating(Student student) {
        return student.calcRating();
    }
}
