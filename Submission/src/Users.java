import java.util.*;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable", "RedundantThrows", "SpellCheckingInspection", "DanglingJavadoc"})
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