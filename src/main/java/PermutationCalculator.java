import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/** A calculator that returns all the possible permutation of a given
 * string. Resultus are stored into a LinkedHashSet to remove duplicates and
 * maintain the permutation order. This class is meant only to calculate the
 * possible permutations so it's build as a singleton type.
 *
 */
public class PermutationCalculator {

    private static PermutationCalculator instance = null;
    private Set<String> permutations;
    private StringBuilder stringBuilder;

    /**Constructs the permutation calculator.
     *
     */
    private PermutationCalculator() {
        this.permutations = new LinkedHashSet<String>();
        this.stringBuilder = new StringBuilder();
    }

    /**Initiates the permutation calculator through lazy implementation.
     * @return PermutationCalculator
     */
    public static PermutationCalculator getInstance() {
        if (instance == null) {
            instance = new PermutationCalculator();
        }
        return instance;
    }

    /**This method coordinates the process
     * @param inputString
     * @return List<String>
     */
    public List<String> getPermutations(String inputString) throws Exception {
        validateString(inputString);
        ArrayList<Character> chars = stringToArrayOfChars(inputString);
        calculatePermutations(chars);
        List<String> result = new ArrayList<String>(permutations);
        clear();
        return result;
    }

    /**Slices the given string into an arrayList of Characters
     * @param string
     * @return ArrayList<Character>
     */
    private ArrayList<Character> stringToArrayOfChars(String string) {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (char c : string.toCharArray()) {
            chars.add(c);
        }
        return chars;
    }


    /**Calculates the possible permutations through a tail-recursion algorithm.
     * Results are stored into permutations set to ensure no duplicates.
     * This method first checks if the given array size to determine if there
     * are any further possible permutations. If there are none the last char
     * of the array is appended to the string builder and the string resulted
     * is inserted into permutations set.
     * If the given array size is greater then 1 then method proceeds to
     * calculate the possible permutation by iterating through characters
     * of the given array and appending them to the string builder then
     * removing them from the array.
     *
     * @param inputCharactersArray
     */
    private void calculatePermutations(ArrayList<Character> inputCharactersArray) {
        if (inputCharactersArray.size() == 1) {
            stringBuilder.append(inputCharactersArray.get(0));
            permutations.add(stringBuilder.toString());
            stringBuilder.setLength(stringBuilder.length() - 1);
        } else{
            for (char curentChar : inputCharactersArray) {
                stringBuilder.append(curentChar);
                ArrayList<Character> newArray =
                        new ArrayList<Character>(inputCharactersArray);
                newArray.remove((Character) curentChar);
                calculatePermutations(newArray);
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
        }
    }


    /** This method clears the permutations set and resets the string
     * builder for further use of the calculator.
     *
     */
    private void clear() {
        permutations.clear();
        stringBuilder.equals("");
    }


    /**This method validates the given string.
     * @param s
     * @throws Exception
     */
    private void validateString(String s) throws Exception {
        if (s == null || s.length()<= 1) throw new Exception("Invalid string." +
                " No valid permutations for a string with length lower then 2.");
    }

}
