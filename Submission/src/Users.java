import BCrypt.BCrypt;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.*;


public class Users {
    //connection variables
    private final String uName = "student";
    private final String uPass = "student";


    // table attributes
    private int userId;
    private String lastName;
    private String firstName;
    private String email;
    private String pswd;
    private String expiration;
    private int isAdmin;
    private int affiliationId;

    //constructors


    public Users(int userId, String lastName, String firstName, String email, String pswd, String expiration, int isAdmin, int affiliationId) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.pswd = pswd;
        this.expiration = expiration;
        this.isAdmin = isAdmin;
        this.affiliationId = affiliationId;
    }

    public Users() {
        userId = 0;
        lastName = "";
        firstName = "";
        email = "";
        pswd = "";
        expiration = "";
        isAdmin = 0;
        affiliationId = 0;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public void fetch() throws DLException {

    }

    public String put() throws DLException {
        return "Hi.";
    }

    public String post() throws DLException {
        return "Hi.";
    }

    public String delete() throws DLException {
        return "Hi.";
    }
      
    /**
      *
      * getPapers() GOES HERE
      *
      */
      
    /**
      *
      * getUser() GOES HERE
      *
      */
      
    /**
      *
      * setUser() GOES HERE
      *
      */ 
      
    /**
      *
      * resetPassword() GOES HERE
      *
      */
        //creates a new password and sends to specified address
        //good for 5 minutes - expiration field in user table
        //email new password to user
    public void resetPassword(String email) throws DLException {
        //create a new random password
        String newRandomPass = createRandomPass();
        //hash the new password
        String randomPassHash = hash(newRandomPass);
        //store a time 5 minutes from now
        String fiveMinutesLater = fiveMinutesFromNow();

        System.out.println(newRandomPass);//testing
        System.out.println(randomPassHash);//testing
        System.out.println(fiveMinutesLater);//testing

        //store hash and set expiration for five minutes from now for email specified in DB
        MySQLDatabase newDB = new MySQLDatabase(uName, uPass);
        try {
            if (newDB.connect()){//connect to DB
                //create SQL string and values for update
                String sqlString = "UPDATE users SET pswd = ?, expiration = ? WHERE email = ?";
                ArrayList<String> valList = new ArrayList<String>();
                valList.add(randomPassHash);
                valList.add(fiveMinutesLater);
                valList.add(email);
                int numAffected = newDB.setData(sqlString, valList);//use prepared statement for setdata
                System.out.println(numAffected);//testing
                newDB.close();//close DB after updating
            }
        } catch (DLException err){
            System.out.println("Error occurred when resetting password.");
            newDB.close();
            throw new DLException(err);
        }
        //send email with new password and message
        String from = "donotreply@csm.com"; //sender email
        String host = "localhost"; //send from the local host
        Properties prop = System.getProperties(); //get system properties
        prop.setProperty("mail.smtp.host", host); //setup mail server
        Session sesh = Session.getDefaultInstance(prop); //get default session
        try{
            MimeMessage message = new MimeMessage(sesh);//create deafult MIME message
            //change settings for message
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Password change request");
            message.setText("You have requested to change your password for the csm system.\n"
                + "Your new password is " + newRandomPass + "\n"
                + "You have 5 minutes to login and set a new password.");
            //send message
            Transport.send(message);
            System.out.println("Message sent successfully!");

        } catch (MessagingException err) {
            System.out.println("Problem Sending Email.");
            throw new DLException(err);
        }

    }

    private String createRandomPass() {
        //create a new password string of random text(8 characters)
        String randomString = "";
        Random rand = null;
        //random number between 1 and 3 = to decide what character range to randomly choose
        int min = 0;
        int max = 0;

        while (randomString.length() < 8) {
            rand = new Random();
            int randint = rand.nextInt(3);

            //if 1 - choose a random lowercase letter
            if (randint == 1) {
                min = 65;
                max = 90;
                randint = rand.nextInt((max - min) + 1) + min;
                char randChar = (char) randint;
                randomString += randChar;

            } else if (randint == 2) { //random uppercase letter
                min = 97;
                max = 122;
                randint = rand.nextInt((max - min) + 1) + min;
                char randChar = (char) randint;
                randomString += randChar;

            } else { //random number 0 - 9
                randint = rand.nextInt(10);
                randomString += Integer.toString(randint);
            }
        }
        return randomString;
    }

    private String fiveMinutesFromNow(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, 5);
        Date fiveMinutesLater = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String returnDateString = dateFormat.format(fiveMinutesLater);
        return returnDateString;

    }
      
    /**
      *
      * setPassword() GOES HERE
      *
      */
      
    /**
      *
      * login() GOES HERE
      *
      */
      //check expiration when user logs in
      //expire after a long time in the future
    /**
      *
      * hash() GOES HERE
      *
      */
    private String hash(String passwd){
        String returnHash = BCrypt.hashpw(passwd, BCrypt.gensalt(12));
        return returnHash;
    }

} // end Users