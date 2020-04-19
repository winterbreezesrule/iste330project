import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class MainTest {
    public static void main(String[] args) {


        try {
            //test login
            Users testUser = new Users();
            //testUser.resetPassword("hl4442@rit.edu");
            String newToken = testUser.login("hl4442@rit.edu", "4hrA1t59");
            System.out.println("Token:" + newToken);

            Jws<Claims> tokenValues = testUser.decodeToken(newToken);

            System.out.println(tokenValues);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
