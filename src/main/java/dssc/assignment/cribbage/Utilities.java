package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {
    public static List<Integer> GenerateSubsetSums(List<Integer> set) {
        List<List<Integer>> PowerSet = GeneratePowerset(set);
        List<Integer> SubsetSums = new ArrayList<>();
        int sum;
        for (List<Integer> Subset : PowerSet) {
            sum = 0;
            for (Integer x : Subset) {
                sum += x;
            }
            SubsetSums.add(sum);
        }
        return SubsetSums;
    }

    public static List<List<Integer>> GeneratePowerset(List<Integer> set) {
        List<List<Integer>> Powerset = new ArrayList<>();
        for (Integer element : set) {
            int size = Powerset.size();
            for (int i = 0; i < size; i++) {
                List<Integer> TemporaryCopy = new ArrayList<>(Powerset.get(i));
                TemporaryCopy.add(element);
                Powerset.add(TemporaryCopy);
            }
            Powerset.add(new ArrayList<>(Arrays.asList(element)));
        }
        return Powerset;
    }
}
