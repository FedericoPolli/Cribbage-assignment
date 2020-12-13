package dssc.assignment.cribbage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utilities {
    public static List<Integer> GenerateSubsetSums(List<Integer> set) {
        List<List<Integer>> PowerSet = GeneratePowerset(set);
        List<Integer> SubsetSums = new ArrayList<>();
        for (List<Integer> Subset : PowerSet) {
            SubsetSums.add(Subset.stream().mapToInt(Integer::intValue).sum());
        }
        return SubsetSums;
    }

    public static List<List<Integer>> GeneratePowerset(List<Integer> set) {
        List<List<Integer>> Powerset = new ArrayList<>();
        List<Integer> TemporaryCopy;
        for (Integer element : set) {
            int size = Powerset.size();
            for (int i = 0; i < size; i++) {
                TemporaryCopy = Powerset.get(i).stream().collect(Collectors.toList());
                TemporaryCopy.add(element);
                Powerset.add(TemporaryCopy);
            }
            Powerset.add(new ArrayList<>(Collections.singletonList(element)));
        }
        return Powerset;
    }
}
