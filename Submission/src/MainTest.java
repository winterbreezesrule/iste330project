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

            // RUN TO RESET PASSWORD TO RANDOM THING
            // newUser.resetPassword("jml7290@g.rit.edu");

            // RUN TO SET NEW PASSWORD
            // newUser.login("jml7290@g.rit.edu", "randomly generated password "emailed" to you");
            // newUser.setPass("testpass");

            // RUN THAT GETS TOKEN
            String tokenString = newUser.login("jml7290@g.rit.edu", "testpass");
            boolean adminStatus =  newUser.admincheck();
            System.out.println("Admin? " + adminStatus);

            Jws<Claims> info = newUser.decodeToken(tokenString);
            System.out.println("Info successfully retrieved");

            Users testUser = new Users();

            System.out.println(testUser.getPapers(9999, tokenString));

            int userId = Integer.parseInt((String) info.getBody().get("UserID"));
            System.out.println(userId);

            System.out.println(info);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
