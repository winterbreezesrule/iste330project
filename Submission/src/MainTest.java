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
            //newUser.resetPassword("luntb@byu.edu");
            String tokenString = newUser.login("ckadlec@georgiasouthern.edu", "newPass");

            // String tokenString = newUser.login("hl4442@rit.edu", "newPass");
            boolean adminStatus =  newUser.admincheck();
            System.out.println(newUser.decodeToken(tokenString));
            System.out.println(adminStatus);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
