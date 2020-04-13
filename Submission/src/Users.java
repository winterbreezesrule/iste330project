import java.util.*;

public class Users {

    // table attributes
    private int userId;
    private String lastName;
    private String firstName;
    private String email;
    private String pswd;
    private String expiration;
    private int isAdmin;
    private int affiliationId;
      
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
        ArrayList<String> values = new ArrayList<String>();

        values.add(Integer.toString(getUserId()));

        MySQLDatabase mysqld = new MySQLDatabase("root", "USO800rubysky#1!");
        try {
            ArrayList<ArrayList<String>> fullResults = mysqld.getData(sql, values);
            ArrayList<String> results = fullResults.get(2);
            userInfo += results.get(0);
        } catch (Exception e) {
            userInfo += "Affiliation could not be properly retrieved.";
        }

        return userInfo;
    }
      
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
      
    /**
      *
      * hash() GOES HERE
      *
      */

} // end Users