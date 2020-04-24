import BCrypt.BCrypt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.DatatypeConverter;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;





import java.util.*;

/**
 * Used to represent the Users table in the CSM database.
 */
@SuppressWarnings({"unused", "UnnecessaryLocalVariable", "RedundantThrows", "SpellCheckingInspection", "DanglingJavadoc"})
public class Users extends DLObject{
    //connection variables
    private final String uName = "root";
    private final String uPass = "USO800rubysky#1!";

    //secret encryption key
    public static String SECRET_KEY;

    // table attributes
    private int userId;
    private String lastName;
    private String firstName;
    private String email;
    private String pswd;
    private String expiration;
    private int isAdmin;
    private int affiliationId;
    private boolean loggedIn = false;
    private String loginToken;

    // constructors
    public Users(int userId, String lastName, String firstName, String email, String pswd, String expiration, int isAdmin, int affiliationId) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.pswd = pswd;
        this.expiration = expiration;
        this.isAdmin = isAdmin;
        this.affiliationId = affiliationId;
        SECRET_KEY = "++Gl8jZDzG/KuHK9QgE64sFQCksjKk3Fke2vpWw53+A=";
        loginToken = "";
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
        SECRET_KEY = "++Gl8jZDzG/KuHK9QgE64sFQCksjKk3Fke2vpWw53+A=";
        loginToken = "";
    }

    /**
     * Gets the user ID.
     * @return the user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     * @param userId is the new user ID.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the last name of the user.
     * @return the user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     * @param lastName is the new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the user.
     * @return the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     * @param firstName is the new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the email of the user.
     * @return the
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * @param email is the new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     * @return the user's password.
     */
    public String getPswd() {
        return pswd;
    }

    /**
     * Sets the password of the user.
     * @param pswd is the new password.
     */
    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    /**
     * Gets the expiration date for the user's password.
     * @return the expiration date of the user's password.
     */
    public String getExpiration() {
        return expiration;
    }

    /**
     * Sets the expiration date for the user's password.
     * @param expiration is the new expiration date.
     */
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    /**
     * Gets if the user is an admin.
     * @return an int indicating if the user is an admin.
     */
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     * Sets the admin status of the user.
     * @param isAdmin is the new status of the user.
     */
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * Gets the affiliation ID of the user.
     * @return the affiliation ID.
     */
    public int getAffiliationId() {
        return affiliationId;
    }

    /**
     * Sets the affiliationID of the user.
     * @param affiliationId is the new affiliation ID.
     */
    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    /**
     * fetch method for the user object. Passes info from this class
     * to the superclass fetch method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch() throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("Users", "userId", Integer.toString(userId));
    }

    /**
     * put method for the user object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("lastName");
        columnNames.add("firstName");
        columnNames.add("email");
        columnNames.add("pswd");
        columnNames.add("expiration");
        columnNames.add("isAdmin");
        columnNames.add("affiliationId");
        columnNames.add("userId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(lastName);
        values.add(firstName);
        values.add(email);
        values.add(pswd);
        values.add(expiration);
        values.add(Integer.toString(isAdmin));
        values.add(Integer.toString(affiliationId));
        values.add(Integer.toString(userId));

        return super.put("Users", columnNames, values, 1);
    }

    /**
     * post method for the user object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post() throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("userId");
        columnNames.add("lastName");
        columnNames.add("firstName");
        columnNames.add("email");
        columnNames.add("pswd");
        columnNames.add("expiration");
        columnNames.add("isAdmin");
        columnNames.add("affiliationId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(userId));
        values.add(lastName);
        values.add(firstName);
        values.add(email);
        values.add(pswd);
        values.add(expiration);
        values.add(Integer.toString(isAdmin));
        values.add(Integer.toString(affiliationId));

        return super.post("Users", columnNames, values);
    }

    /**
     * delete method for the user object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete() throws DLException {
        return super.delete("Users", "userId", Integer.toString(userId));
    }

    /**
      *
      * Gets all of the papers for the specified user.
     *
     * @param _userId is the user to retrieve papers for
     * @return a string containing the list of papers the user has written
      *
      */

    public String getPapers(int _userId, String token) throws DLException {
        String papersWritten = "";
        MySQLDatabase mysqld = new MySQLDatabase(uName, uPass);

        Users testUser = new Users();

        Jws<Claims> tokenClaims = testUser.decodeToken(token);

        int admin = Integer.parseInt((String) tokenClaims.getBody().get("IsAdmin"));
        int loginUserId = Integer.parseInt((String) tokenClaims.getBody().get("UserID"));

        if (admin == 1 || _userId == loginUserId) {
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

                    for (String result : results) {
                        papersWritten = result + "\n";
                    }

                    mysqld.close();
                }
            } catch (Exception e) {
                papersWritten += "Could not retrieve list of papers written by inputted user.";
            }
        } else {
            papersWritten += "You cannot view papers written by another author. Are you an admin?";
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

    public String getUser() throws DLException {
        String userInfo = "";

        userInfo += "User ID: " + getUserId();
        userInfo += "\nName: " + getFirstName() + " " + getLastName();
        userInfo += "\nEmail: " + getEmail();
        userInfo += "\nPassword Expiration: " + getExpiration();
        userInfo += "\nIs admin? ";
        // CHECK AND SEE IF 1 IS ADMIN AND 0 IS NONADMIN
        if (isAdmin == 1) {
            userInfo += "Yes.";
        } else if (isAdmin == 0) {
            userInfo += "No.";
        }
        userInfo += "\nAffiliation: ";
        try {
            MySQLDatabase mysqld = new MySQLDatabase(uName, uPass);
            if (mysqld.connect()) {
                String sql = "select affiliationName from _affiliations where affiliationId = ?;";
                ArrayList<String> values = new ArrayList<String>();
                values.add(Integer.toString(getAffiliationId()));

                ArrayList<ArrayList<String>> results = mysqld.getData(sql, values);
                if (results.get(2).get(0) == null) {
                    userInfo += "N/A";
                } else {
                    userInfo += results.get(2).get(0);
                }
                mysqld.close();
            } else {
                userInfo += "N/A";
            }
        } catch (Exception e) {
            System.out.println("Affiliation could not be retrieved.");
            throw new DLException(e);
        }

        return userInfo;
    }

    /**
      *
      * Sets the current user to the information provided. If a userId is not currently
     * set, a new user is created and added to the database. If a userId is set, the
     * information about the user is updated. Note that if a userId is set, it must be
     * matched against the currently logged-in user.
     *
     * @param _lastName is the user's last name
     * @param _firstName is the user's first name
     * @param _email is the email of the user
     * @param affiliation is the id of the institute the user is affiliated with
      *
      */

    public void setUser(String _lastName, String _firstName, String _email,
                        int affiliation, String token) throws DLException {
        MySQLDatabase mysqld = new MySQLDatabase(uName, uPass);
        Users testUser = new Users();

        Jws<Claims> tokenClaims = testUser.decodeToken(token);

        int admin = Integer.parseInt((String) tokenClaims.getBody().get("IsAdmin"));
        int loginUserId = Integer.parseInt((String) tokenClaims.getBody().get("UserID"));

        // creates new user entry
        if (getUserId() == 0) {
            try {
                if (mysqld.connect()) {
                    // sql statements needed
                    System.out.println("Creating new user.");
                    String sql1 = "INSERT INTO users (userId, lastName, firstName, " +
                            "email, affiliationId) VALUES (?, ?, ?, ?, ?)";
                    String sql2 = "SELECT MAX(userId) from users";

                    ArrayList<String> values1 = new ArrayList<>();
                    ArrayList<String> values2 = new ArrayList<>();

                    ArrayList<ArrayList<String>> fullResults2 = mysqld.getData(sql2, values2);
                    ArrayList<String> results2 = fullResults2.get(2);

                    setUserId(Integer.parseInt(results2.get(0)) + 1);
                    setLastName(_lastName);
                    setFirstName(_firstName);
                    setEmail(_email);
                    setAffiliationId(affiliation);

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
        } else if (admin == 1 || loginUserId == getUserId()) { // updates existing info for user
            try {
                if (mysqld.connect()) {
                    System.out.println("Updating info on user.");
                    String sql = "UPDATE users SET lastName = ?, firstName = ?, email = ?" +
                            ", affiliationId = ? WHERE userId = ?";
                    ArrayList<String> values = new ArrayList<>();

                    // set new user info
                    setLastName(_lastName);
                    setFirstName(_firstName);
                    setEmail(_email);
                    setAffiliationId(affiliation);

                    values.add(getLastName());
                    values.add(getFirstName());
                    values.add(getEmail());
                    values.add(Integer.toString(getAffiliationId()));
                    values.add(Integer.toString(getUserId()));

                    // try to update user info
                    int recordschanged = mysqld.setData(sql, values);

                    // print how many records were changed
                    System.out.println(recordschanged + " records changed.");

                    mysqld.close();
                }
            } catch (Exception e) {
                System.out.println("Information could not be updated for current user.");
            }
        } else {
            System.out.println("Could not update user information. Are you an admin?");
        }
    }

    /**
      *
      * Creates a new password and sends to specified address.
     * Good for five minutes.
     *
     * @param email is the email to send the new password to
      *
      */
        //creates a new password and sends to specified address
        //good for 5 minutes - expiration field in user table
        //email new password to user
    public int resetPassword(String email) throws DLException {
        int numAffected = 0;

        //create a new random password
        String newRandomPass = createRandomPass();
        //hash the new password
        String randomPassHash = hash(newRandomPass);
        //store a time 5 minutes from now
        String fiveMinutesLater = fiveMinutesFromNow();

        //store hash and set expiration for five minutes from now for email specified in DB
        MySQLDatabase newDB = new MySQLDatabase(uName, uPass);
        try {
            if (newDB.connect()){//connect to DB
                //create SQL string and values for update
                String sqlString = "UPDATE users SET pswd = ?, expiration = ? WHERE email = ?";
                ArrayList<String> valList = new ArrayList<>();
                valList.add(randomPassHash);
                valList.add(fiveMinutesLater);
                valList.add(email);
                numAffected = newDB.setData(sqlString, valList);//use prepared statement for setdata
                newDB.close();//close DB after updating
            }
        } catch (DLException err){
            System.out.println("Error occurred when resetting password.");
            newDB.close();
            throw new DLException(err);
        }
        if (numAffected > 0){
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

            } catch (MessagingException err) {
                System.out.println("Problem Sending Email.");
                throw new DLException(err);
            }
        }

        return numAffected;
    }

    /**
     * Creates a new random password String.
     * @return the new, random password.
     */
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

    /**
     * Gets the time five minutes from now.
     * @return a string holding the time five minutes from now.
     */
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

    private String sixMonthsFromNow(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MONTH, 6);
        Date sixMonthsLater = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String returnDateString = dateFormat.format(sixMonthsLater);
        return returnDateString;
    }

    /**
      *
      * setPassword() GOES HERE
      *
      */
    //set password --
        //checks if user is logged in
        //-accepts a string of text
        //-creates a hash of it
        //-stores hash in password field users table
    public void setPassword(String pass) throws DLException {
        if(logincheck()){ //if login has a token and token is not expired
            //store hashed password in database
            String newPassHash = hash(pass);
            MySQLDatabase  newDB = new MySQLDatabase(uName, uPass);
            try {
                if (newDB.connect()){
                    //create and execute a prepared statement
                    String sqlString = "UPDATE users SET pswd = ?, expiration = ? WHERE email = ?";
                    ArrayList<String> valList = new ArrayList<String>();
                    valList.add(newPassHash);
                    valList.add(sixMonthsFromNow());
                    Jws<Claims> checkClaims = decodeToken(loginToken);
                    valList.add((String) checkClaims.getBody().get("email"));
                    int numaffected = newDB.setData(sqlString, valList);
                    newDB.close();
                }
            } catch (DLException err){
                System.out.println("Error occured when setting new password.");
                throw new DLException(err);
            }
        }
    }

    /**
      *
      * Checks the expiration of a user's password when they log in. If their
     * password has expired, they cannot log in. Otherwise, they either successfully
     * log in, if their password is correct, or are told otherwise.
     *
     * @param email is the user's email
     * @param pass is the user's password
     * @return a String describing if the user successfully logged in
      *
      */
    public String login(String email, String pass) throws DLException {
        String tokenString = "";
        //check if password is expired
        MySQLDatabase newDB = new MySQLDatabase(uName, uPass);
        try {
            if(newDB.connect()){ //connect to DB
                //prepare a statement to return DB values for this user
                String sqlString = "SELECT * FROM users WHERE email = ?";
                ArrayList<String> valList = new ArrayList<String>();
                valList.add(email);
                ArrayList<ArrayList<String>> returnVals = newDB.getData(sqlString,valList);
                //if password is not expired
                if(!isExpired(returnVals.get(2).get(6))){
                    //if password matches
                    if(BCrypt.checkpw(pass, returnVals.get(2).get(4))){
                        //create a token to send back
                            //token variables
                                //-userID, lastName, firstName, isAdmin, expiration
                        tokenString = createToken(returnVals.get(2).get(0),
                                returnVals.get(2).get(1),
                                returnVals.get(2).get(2),
                                returnVals.get(2).get(3),
                                returnVals.get(2).get(7),
                                returnVals.get(2).get(6));

                        loginToken = tokenString;

                    }else{//password doesn't match
                        System.out.println("Password is not correct!");//testing
                    }

                }else{ //password is expired
                    System.out.println("Expired");//testing
                }
                newDB.close();

            }
        }catch (DLException | IndexOutOfBoundsException err){
            System.out.println("Error occurred when logging in. Make sure email and password are correct.");
            newDB.close();
            throw new DLException(err);
        }catch (IllegalArgumentException err){
            System.out.println("User password must be reset before logging in.");
            throw new DLException(err);
        }

        return tokenString;

    }
    /**
      *
      * DESCRIBE WHAT THIS DOES HERE
     *
     * @param passwd is the password to hash.
     * @return the hashed password.
      *
      */
    private String hash(String passwd){
        String returnHash = BCrypt.hashpw(passwd, BCrypt.gensalt(12));
        return returnHash;
    }

    /**
     * Checks if timestamp is expired.
     * @param timestamp is the current time (?)
     * @return if the timestamp is expired
     * @throws DLException [oh god damn it do we have to do this]
     */
    private boolean isExpired(String timestamp) throws DLException {
        boolean returnVal = true;//assume it is expired for security
        //parse string into date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date timeStampDate = dateFormat.parse(timestamp);
            Date rightNow = new Date();
            //compare two dates
            if(rightNow.compareTo(timeStampDate) > 0){
                // do nothing - return value already true
            } else {
                returnVal = false; // set value to false because pass is not expired
            }

        } catch (ParseException err){
            System.out.println("There was an error checking if password is expired.");
            throw new DLException(err);
        }

        return returnVal;
    }

    /**
     * Creates a token.
     * Following instructions used here: https://developer.okta.com/blog/2018/10/31/jwts-with-java
     * @param uID
     * @param lastName
     * @param firstName
     * @param isAdmin
     * @param expiration
     * @return
     */

    public String createToken(String uID, String lastName, String firstName, String email, String isAdmin, String expiration){
        //choose signature algorithm
        SignatureAlgorithm sigAl = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);


        //need a a secret key to sign the token
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, sigAl.getJcaName());

        //Set the JWT claims
        JwtBuilder builder = Jwts.builder();
        builder.claim("UserID", uID);
        builder.claim("FirstName", firstName);
        builder.claim("LastName", lastName);
        builder.claim("email", email);
        builder.claim("IsAdmin", isAdmin);
        builder.claim("Expiration", expiration);
        builder.signWith(signingKey, sigAl);
        builder.setExpiration(newTokenExpiration());
        //create token string
        String jwtString = builder.compact();

        return jwtString;
    }

    /**
     * Generates a key.
     * @return the new key. NOT USED BECAUSE WE'RE HARDCODING,
     * BUT KEEPING IN CASE WE NEED TO GENERATE A NEW KEY

    public String genKey(){
        Key newKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String returnVal = Encoders.BASE64.encode(newKey.getEncoded());
        return returnVal;
    }*/

    /**
     * Sets the new date for the token's expiration.
     * @return
     */
    private Date newTokenExpiration(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, 30);
        Date thirtyMinutesLater = cal.getTime();
        return thirtyMinutesLater;

    }

    /**
     * Decodes the token.
     * @param jwtString
     * @return a Jws<Claims> that contains information on the token
     * @throws DLException
     */
    public Jws<Claims> decodeToken(String jwtString) throws DLException {
        Jws<Claims> newJWS;
        try {
            newJWS = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(jwtString);
        } catch (JwtException err){
            System.out.println("Error occurred when decoding token");
            throw new DLException(err);
        }

        return newJWS;
    }
    //checks if token exists, and is not expired
    public boolean logincheck() throws DLException {
        boolean checkVal = false;
        if (loginToken != ""){ //if token exists
            try {
                Jws<Claims> tokenClaims = decodeToken(loginToken);
                Date rightNow = new Date();
                //if token is still valid
                if(rightNow.before(tokenClaims.getBody().getExpiration())){
                    checkVal = true;
                }

            } catch (DLException err){
                System.out.println("Error occured when checking token");
                throw new DLException(err);
            }

        }
        return checkVal;
    }

    public boolean admincheck() throws DLException {
        boolean isAdmin = false;
        if (loginToken != ""){ //if token exists
            try {
                Jws<Claims> tokenClaims = decodeToken(loginToken);
                if (tokenClaims.getBody().get("IsAdmin").toString().equals("1")){
                    isAdmin = true;
                }

            } catch (DLException err){
                System.out.println("Error occured when checking admin status");
                throw new DLException(err);
            }
        }
        return isAdmin;
    }

} // end Users