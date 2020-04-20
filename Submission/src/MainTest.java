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
            //test login
            // Users testUser = new Users();
            //testUser.resetPassword("hl4442@rit.edu");
            // String newToken = testUser.login("hl4442@rit.edu", "4hrA1t59");
            // System.out.println("Token:" + newToken);

            // Jws<Claims> tokenValues = testUser.decodeToken(newToken);

            // System.out.println(tokenValues);

            PaperAuthors test = new PaperAuthors();
            test.setPaperId(1);
            test.setUserId(558);
            test.fetch();



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
