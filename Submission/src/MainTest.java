/**
 * The main class we use to test our methods.
 */

public class MainTest {

    /**
     * The main method we use to test methods. Used for pretty much anything
     * we can think of for testing.
     *
     * @param args goes unused here.
     */
    public static void main(String[] args) {


        try {
            //test login
            Users testUser = new Users();
            testUser.resetPassword("hl4442@rit.edu");
        } catch (Exception e) {

        }


    }
}
