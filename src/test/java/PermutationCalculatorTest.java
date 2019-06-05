import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class PermutationCalculatorTest {

    PermutationCalculator permutationCalculator;
    List<String> result;
    List<String> expected;

    @Before
    public void init() {
        permutationCalculator = PermutationCalculator.getInstance();
        expected = new ArrayList<String>();
        expected.add("abc");
        expected.add("acb");
        expected.add("bac");
        expected.add("bca");
        expected.add("cab");
        expected.add("cba");
    }

    @Test
    public void getPermutations() throws Exception {
        result = permutationCalculator.getPermutations("abc");
        assertArrayEquals(result.toArray(), expected.toArray());
        for (String s : result) {
            System.out.println(s);
        }

    }


    @Test(expected = Exception.class)
    public void nullStringException() throws Exception {
        String test = null;
        permutationCalculator.getPermutations(test);
    }

    @Test(expected = Exception.class)
    public void invalidStringException() throws Exception {
        String test = "a";
        permutationCalculator.getPermutations(test);
    }
}