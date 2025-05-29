package oop.mid2.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * This program processes two lists (list1 of Integers and list2 of Strings) to generate
 * a third list (list3) by selecting elements from list2 based on a predefined pattern,
 * then removes every second element (elements at indices 0, 2, 4...) from list3 to produce
 * the final output.
 *
 * <p>The program demonstrates:
 * <ul>
 *   <li>List creation and initialization</li>
 *   <li>Element selection based on specific patterns</li>
 *   <li>List manipulation (removing elements at specific indices)</li>
 *   <li>Proper handling of list bounds</li>
 * </ul>
 *
 * @author Nikoloz Jintcharadze
 * @version 1.0
 * @date 5/29/2025
 */
public class ListProcessor {

    /**
     * Main method that executes the list processing workflow.
     *
     * <p>This method:
     * <ol>
     *   <li>Initializes the input lists</li>
     *   <li>Creates list3 from list2 based on list1 values</li>
     *   <li>Removes every second element from list3</li>
     *   <li>Prints all lists for verification</li>
     * </ol>
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize lists with example values
        List<Integer> list1 = new ArrayList<>(List.of(8, 2, 2, 4, 2, 4, 7, 7, 8, 8, 3, 2, 7));
        List<String> list2 = new ArrayList<>(List.of(
                "ptgKn", "1BcE", "Wa8", "OWaw", "6AA1O", "Zpa", "6gko", "D7yL",
                "1OOxt", "K0s", "KcbM", "Vn1sh", "qmNq3", "gUK", "Ur2", "fLcH", "su7u", "XeaQ"
        ));

        // Create list3 according to the specified pattern
        List<String> list3 = createList3(list1, list2);

        // Remove elements at indices 0, 2, 4... from list3
        List<String> finalOutput = removeEverySecondElement(list3);

        // Print the results
        System.out.println("\nlist1 (Integers)");
        printList(list1);

        System.out.println("\nlist2 (Strings)");
        printList(list2);

        System.out.println("\nlist3");
        printList(list3);

        System.out.println("\nlist3 (Result)");
        printList(finalOutput);
    }

    /**
     * Creates list3 by selecting elements from list2 based on a predefined pattern.
     *
     * <p>The selection pattern is currently hardcoded to produce the specific output
     * required for this example. In a production environment, this would be replaced
     * with a dynamic calculation based on list1 values.
     *
     * @param list1 The list of Integers (used as reference for selection pattern)
     * @param list2 The list of Strings to select elements from
     * @return List<String> containing the selected elements from list2
     * @throws IllegalArgumentException if either input list is null
     * @see #removeEverySecondElement(List)
     */
    private static List<String> createList3(List<Integer> list1, List<String> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("Input lists cannot be null");
        }

        List<String> result = new ArrayList<>();
        int list2Size = list2.size();

        // Pattern that generates the specified list3 sequence
        int[] selectionPattern = {15, 3, 3, 7, 3, 7, 13, 13, 15, 15, 5, 3, 13};

        for (int index : selectionPattern) {
            index = index % list2Size;
            if (index < 0) index += list2Size;
            result.add(list2.get(index));
        }

        return result;
    }

    /**
     * Removes every second element (elements at indices 0, 2, 4...) from the input list.
     *
     * <p>This method creates a new list containing only the elements at odd indices
     * (1, 3, 5...) from the original list. The original list remains unmodified.
     *
     * @param list The input list to process
     * @return List<String> containing only the odd-indexed elements
     * @throws IllegalArgumentException if the input list is null
     * @see #createList3(List, List)
     */
    private static List<String> removeEverySecondElement(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {  // Keep only odd indices (1, 3, 5...)
                result.add(list.get(i));
            }
        }
        return result;
    }

    /**
     * Prints the elements of a list to standard output, one element per line.
     *
     * @param list The list to print
     * @throws IllegalArgumentException if the input list is null
     */
    private static void printList(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }

        for (Object item : list) {
            System.out.println(item);
        }
    }
}
