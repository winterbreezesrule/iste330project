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

            Users test = new Users();

            test.setUserId(9);

            // test.fetch(info);
            // test.post(info);
            test.put(info);
            test.delete(info);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
