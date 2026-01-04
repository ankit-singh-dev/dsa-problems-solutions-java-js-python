import java.util.*;
import java.util.stream.Collectors;

public class StringCl {

    public static void main(String[] args) {
        //String input = "ankitdankitd";
        //char ch = 'd';

        //System.out.println(removeChar(input, ch));

        //List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);
        //removeDuplicate(myList);

        List<List<String>> listOfLiterals = Arrays.asList(
                Arrays.asList("Reflection", "Collection", "Stream"),
                Arrays.asList("Structure", "State", "Flow"),
                Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        someOperation(listOfLiterals);
    }

    private static void someOperation(List<List<String>> list){
        /*



        - Response should be a list
- Response list should contain only the strings starting with S
- Response shouldn’t contain duplicate items
- Response should be sorted in ascending order

         */

        List<String> mainList = new ArrayList<>(); //
        Set<String> sets = new HashSet<>();

        for(List<String> tempList : list){
            for(String str : tempList){
                if(str.startsWith("S")) {
                    if (!sets.contains(str)) {
                        sets.add(str);
                        mainList.add(str);
                    }
                    sets.add(str);
                }
            }
        }

        Comparator<String> comp = (string1, string2) -> string1.compareTo(string2);

        Collections.sort(mainList, comp);

        System.out.println(mainList);
    }

    private static void removeDuplicate(List<Integer> myList){

        Set<Integer> mySet = myList.stream().collect(Collectors.toSet());
        System.out.println(mySet);
    }

    private static String removeChar(String input, char ch){

        StringBuilder stringBuilder = new StringBuilder();

        for(char cChar : input.toCharArray()){
            if(cChar == ch){
                continue;
            }

            stringBuilder.append(cChar);
        }

        return stringBuilder.toString();
    }
}
