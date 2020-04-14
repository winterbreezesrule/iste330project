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


import java.util.*;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable", "RedundantThrows", "SpellCheckingInspection", "DanglingJavadoc"})
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
      * Gets all of the papers for the specified user.
     *
     * @param _userId is the user to retrieve papers for
     * @return a string containing the list of papers the user has written
      *
      */

    public String getPapers(int _userId) {
        String papersWritten = "";
        MySQLDatabase mysqld = new MySQLDatabase("root", "USO800rubysky#1!");

        try {
            if (mysqld.connect()) {

                String sql = "select papers.title from papers inner " +
                        "join paperauthors on papers.paperid = " +
                        "paperauthors.paperid inner join users " +
                        "on paperauthors.userid = users.userid " +
                        "and users.userid = ?;";
                ArrayList<String> values = new ArrayList<>();

                values.add(Integer.toString(_userId));

                ArrayList<ArrayList<String>> fullResults = mysqld.getData(sql, values);
                ArrayList<String> results = fullResults.get(2);

                for (int i = 0; i < results.size(); i++) {
                    papersWritten = results.get(i) + "\n";
                }

                mysqld.close();
            }
        } catch (Exception e) {
            papersWritten += "Could not retrieve list of papers written by inputted user.";
        }

        return papersWritten;
    }

    /**
      *
      * Returns info for the instantiated user aside from password.
     *
     * @return a string with the info of the user
      *
      */

    public String getUser() {
        String userInfo = "";

        userInfo += "Name: " + getFirstName() + " " + getLastName();
        userInfo += "\nEmail: " + getEmail();
        userInfo += "\nAffiliation: ";

        // need SQL to get affiliation name
        String sql = "select _affiliations.affiliationName from users inner " +
                "join _affiliations on users.affiliationId = _affiliations." +
                "affiliationId AND userId = ?;";
        ArrayList<String> values = new ArrayList<>();

        values.add(Integer.toString(getUserId()));

        MySQLDatabase mysqld = new MySQLDatabase("root", "USO800rubysky#1!");
        try {
            if (mysqld.connect()) {
                ArrayList<ArrayList<String>> fullResults = mysqld.getData(sql, values);
                ArrayList<String> results = fullResults.get(2);
                userInfo += results.get(0);
                mysqld.close();
            }
        } catch (Exception e) {
            userInfo += "Affiliation could not be properly retrieved.";
        }

        return userInfo;
    }

    /**
      *
      * Sets the current user to the information provided. If a userId is not currently
     * set, a new user is created and added to the database. If a userId is set, the
     * information about the user is updated.
     *
     * @param _lastName is the user's last name
     * @param _firstName is the user's first name
     * @param _email is the email of the user
     * @param affiliation is the institute the user is affiliated with
      *
      */

    public void setUser(String _lastName, String _firstName, String _email,
                        String affiliation) {

        MySQLDatabase mysqld = new MySQLDatabase("root", "USO800rubysky#1!");

        // get ID associated with affiliation
        try {
            if (mysqld.connect()) {
                String sql = "select affiliationId FROM _affiliations WHERE affiliationName = ?;";
                ArrayList<String> values = new ArrayList<>();
                values.add(affiliation);
                ArrayList<ArrayList<String>> fullResults = mysqld.getData(sql, values);
                // affiliation does not exist in _affiliations, must be added
                if (fullResults.isEmpty()) {
                    String sql2 = "select MAX(affiliationId) from _affiliations";
                    ArrayList<String> values2 = new ArrayList<>();
                    ArrayList<ArrayList<String>> fullResults2 = mysqld.getData(sql2, values2);
                    ArrayList<String> results = fullResults2.get(2);
                    int affid = Integer.parseInt(results.get(0));

                    Affiliations newAff = new Affiliations();

                    newAff.setAffiliationId(affid);
                    newAff.setAffiliationName(affiliation);

                    newAff.post();

                    setAffiliationId(affid);

                } else { // affiliation already exists, can get ID
                    ArrayList<String> results = fullResults.get(2);
                    int affid = Integer.parseInt(results.get(0));
                    setAffiliationId(affid);
                }
                mysqld.close();
            }
        } catch (Exception e) {
            System.out.println("Could not retrieve ID associated with the user's affiliation.");
        }

        if (getUserId() == 0) { // creates new user entry
            try {
                if (mysqld.connect()) {
                    System.out.println("Creating new user.");
                    String sql1 = "INSERT INTO users (userId, lastName, firstName, " +
                            "email, affiliationId) VALUES (?, ?, ?, ?, ?)";
                    String sql2 = "SELECT MAX(userId) from users";
                    ArrayList<String> values1 = new ArrayList<>();
                    ArrayList<String> values2 = new ArrayList<>();

                    ArrayList<ArrayList<String>> fullResults2 = mysqld.getData(sql2, values2);
                    ArrayList<String> results2 = fullResults2.get(2);
                    setUserId(Integer.parseInt(results2.get(0)));

                    values1.add(Integer.toString(getUserId()));
                    values1.add(getLastName());
                    values1.add(getFirstName());
                    values1.add(getEmail());
                    values1.add(Integer.toString(getAffiliationId()));

                    int recordschanged = mysqld.setData(sql1, values1);

                    System.out.println(recordschanged + " records changed.");

                    mysqld.close();
                }
            } catch (Exception e) {
                System.out.println("New user could not be added.");
            }
        } else { // updates existing info for user
            try {
                if (mysqld.connect()) {
                    System.out.println("Updating info on user.");
                    String sql = "UPDATE users SET lastName = ?, firstName = ?, email = ?" +
                            ", affiliationId = ? WHERE userId = ?";
                    ArrayList<String> values = new ArrayList<>();

                    values.add(getLastName());
                    values.add(getFirstName());
                    values.add(getEmail());
                    values.add(Integer.toString(getAffiliationId()));
                    values.add(Integer.toString(getUserId()));

                    int recordschanged = mysqld.setData(sql, values);

                    System.out.println(recordschanged + " records changed.");

                    mysqld.close();
                }
            } catch (Exception e) {
                System.out.println("Information could not be updated for current user.");
            }
        }
    }
      
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