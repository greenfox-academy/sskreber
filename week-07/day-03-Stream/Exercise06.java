//Write a Stream Expression to find the strings which starts with A and ends with I in the following array:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise06 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS"));

        List<String> stringsStartingAandEndingI =
                cities.stream()
                        .filter(n -> n.startsWith("A") && n.endsWith("I"))
                        .collect(Collectors.toList());

        System.out.println(stringsStartingAandEndingI);
    }
}

