package FistBump;
import java.util.ArrayList;

/**
 * Uses an implementation of QuickSort pulled from the internet https://www.geeksforgeeks.org/quick-sort/
 */
public class PaySort implements InternshipSortBehavior {
    public void sort(ArrayList<Internship> internships) {
        quickSort(internships, 0, internships.size() - 1);
    }

    private void quickSort(ArrayList<Internship> internships, int low, int high) {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now
            at right place */
            int pi = partition(internships, low, high);

            quickSort(internships, low, pi - 1);  // Before pi
            quickSort(internships, pi + 1, high); // After pi
        }
    }

    private int partition (ArrayList<Internship> internships, int low, int high) {
        // pivot (Element to be placed at right position)
        double pivot = getPay(internships.get(high));
        int i = (low - 1);  // Index of smaller element and indicates the 
                    // right position of pivot found so far

        for (int j = low; j <= high - 1; j++)
        {
            // If current element is smaller than the pivot
            if (getPay(internships.get(j)) < pivot)
            {
                i++;    // increment index of smaller element
                //swap arr[i] and arr[j]
                Internship temp = internships.get(j);
                internships.set(j, internships.get(i));
                internships.set(i, temp);
            }
        }
        //swap arr[i + 1] and arr[high])
        Internship temp = internships.get(i + 1);
        internships.set(i + 1, internships.get(high));
        internships.set(high, temp);
        return i + 1;
    }

    private double getPay(Internship internship) {
        return internship.getPay();
    }
}
