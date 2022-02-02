package bracketcove.testablecode;

public class ValidatorTests {
    private static final String TEST_ONE = "Valid short username";
    private static final String TEST_TWO = "Valid long username";
    private static final String TEST_THREE = "Invalid short username";
    private static final String TEST_FOUR = "Invalid long username";
    private static final String TEST_FIVE = "Empty  username";
    private static final String TEST_SIX = "Null username";

    private static final String SUCCESSFUL = " was successful";
    private static final String FAILED = " has failed";



    public static void main(String[] args) {
        testValidNames();
        testInvalidNames();
    }

    /**
     * Success only if true (valid) is returned
     */
    private static void testValidNames() {
        if(Validator.validateUserName("ryankay")) testLogger(TEST_ONE, SUCCESSFUL);
        else testLogger(TEST_ONE, FAILED);

        if(Validator.validateUserName("ryankay12345")) testLogger(TEST_TWO, SUCCESSFUL);
        else testLogger(TEST_TWO, FAILED);
    }

    /**
     * Success only if false (invalid) is returned
     */
    private static void testInvalidNames() {
        if(!Validator.validateUserName("ryank@y")) testLogger(TEST_THREE, SUCCESSFUL);
        else testLogger(TEST_THREE, FAILED);

        if(!Validator.validateUserName("ryankay12#456")) testLogger(TEST_FOUR, SUCCESSFUL);
        else testLogger(TEST_FOUR, FAILED);

        if(!Validator.validateUserName("")) testLogger(TEST_FIVE, SUCCESSFUL);
        else testLogger(TEST_FIVE, FAILED);

        if(!Validator.validateUserName(null)) testLogger(TEST_SIX, SUCCESSFUL);
        else testLogger(TEST_SIX, FAILED);
    }


    private static void testLogger(String testName, String result) {
        System.out.println("Test " + testName + result);
    }
}
