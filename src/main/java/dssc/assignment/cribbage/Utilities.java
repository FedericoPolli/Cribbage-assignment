package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {
    public static List<Integer> GenerateSubsetSums(List<Integer> set) {
        List<List<Integer>> PowerSet = GeneratePowerset(set);
        /*
        List<Integer> SubsetSums = new ArrayList<>();
        for (List<Integer> Subset : PowerSet) {
            SubsetSums.add(Subset.stream().mapToInt(Integer::intValue).sum());
        }
        return SubsetSums;
        */
        return PowerSet.stream().map( subset -> subset.stream().mapToInt(Integer::intValue).sum() ).collect(Collectors.toList());
    }

    public static List<List<Integer>> GeneratePowerset(List<Integer> set) {
        List<List<Integer>> Powerset = new ArrayList<>();
        for (Integer element : set) {
            PopulatePowerset(Powerset, element);
        }
        return Powerset;
    }

    private static void PopulatePowerset(List<List<Integer>> Powerset, Integer element) {
        int size = Powerset.size();
        List<Integer> TemporaryCopy;
        for (int i = 0; i < size; i++) {
            TemporaryCopy = new ArrayList<>(Powerset.get(i));
            TemporaryCopy.add(element);
            Powerset.add(TemporaryCopy);
        }
        Powerset.add(new ArrayList<>(Collections.singletonList(element)));
    }
}
