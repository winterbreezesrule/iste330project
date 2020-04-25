/**
 * The main class we use to test our methods.
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class MainTest {

    /**
     * The main method we use to test methods. Used for pretty much anything
     * we can think of for testing.
     *
     * @param args goes unused here.
     */
    public static void main(String[] args) {

        try {

            Users newUser = new Users();
            // newUser.resetPassword("luntb@byu.edu");
            // String tokenString = newUser.login("ckadlec@georgiasouthern.edu", "newPass");

            String tokenString = newUser.login("jml7290@g.rit.edu", "testpass");

            Jws<Claims> info = newUser.decodeToken(tokenString);

            System.out.println(info);

            // Users testUser = new Users();

            // System.out.println(testUser.getPapers(9999, tokenString));
            // System.out.println(testUser.getUser());

            // testUser.setUser("Long", "Jay", "jml7290@g.rit.edu", 0, tokenString);
            // Papers testPaper = new Papers();

            // System.out.println(testPaper.getPaper(99999, tokenString));

            // int[] subids = {1};
            // int[] coids = {1};
            // testPaper.setPaper(0, "Test", "Test", 1, "Test", subids, coids, tokenString);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
