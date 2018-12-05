package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "'','false'",
            "'aaa','false'",
            "'g','false'",
            "'gga','true'",
            "'agga','true'",
            "'agg','true'",
            "'aggg','true'",
            "'aggagg','true'",
            "'aggag','false'",
            "'agagg','false'"
    })
    public void testAlgorithm(String str, boolean expectedResult) {
        boolean result = new GHappy().gHappy(str);
        Assertions.assertEquals(expectedResult, result);
    }

    // TODO: str is null
}
