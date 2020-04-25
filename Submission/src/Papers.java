import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.*;
/**
 * Used to represent the Papers table in the CSM database.
 */

public class Papers extends DLObject{
    //connection variables
    private final String uName = "root";
    private final String uPass = "USO800rubysky#1!";

    // table attributes
    private int paperId;
    private String title;
    // abstract is a reserved word in java--corresponds
    // to abstract MEDIUMTEXT
    private String paperAbstract;
    private String track;
    private String status;
    private int submissionType;
    private int submitterId;
    private String fileId;
    private String tentativeStatus;

    /**
     * Gets the ID associated with this paper.
     * @return the ID of the paper.
     */
    public int getPaperId() {
        return paperId;
    }

    /**
     * Sets the ID associated with this paper.
     * @param paperId is the ID to set.
     */
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    /**
     * Gets the title of this paper.
     * @return the title of the paper.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the paper.
     * @param title is the new title of the paper.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the abstract of the paper.
     * @return the paper abstract.
     */
    public String getPaperAbstract() {
        return paperAbstract;
    }

    /**
     * Sets the abstract of the paper.
     * @param paperAbstract is the new abstract of the paper.
     */
    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    /**
     * Gets the track of the paper.
     * @return the track of the paper.
     */
    public String getTrack() {
        return track;
    }

    /**
     * Sets the track of the paper.
      * @param track is the new track of the paper.
     */
    public void setTrack(String track) {
        this.track = track;
    }

    /**
     * Gets the status of the paper.
     * @return the status of the paper.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the paper.
     * @param status is the new status of the paper.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the submission type of the paper.
     * @return the submission type of the paper.
     */
    public int getSubmissionType() {
        return submissionType;
    }

    /**
     * Sets the submission type of the paper.
     * @param submissionType is the new submission type.
     */
    public void setSubmissionType(int submissionType) {
        this.submissionType = submissionType;
    }

    /**
     * Gets the ID of the person who submitted the paper.
     * @return the submitter ID.
     */
    public int getSubmitterId() {
        return submitterId;
    }

    /**
     * Sets the ID of the person who submitted the paper.
     * @param submitterId is the new submitter ID.
     */
    public void setSubmitterId(int submitterId) {
        this.submitterId = submitterId;
    }

    /**
     * Gets the file ID of the paper.
     * @return the file ID of the paper.
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * Sets the file ID of the paper.
     * @param fileId is the new file ID.
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     * Gets the tentative status of the paper.
     * @return the tentative status of the paper.
     */
    public String getTentativeStatus() {
        return tentativeStatus;
    }

    /**
     * Sets the tentative status of the paper.
     * @param tentativeStatus is the new tenative status.
     */
    public void setTentativeStatus(String tentativeStatus) {
        this.tentativeStatus = tentativeStatus;
    }

    /**
     * fetch method for the paper object. Passes info from this class
     * to the superclass fetch method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch(Jws<Claims> token) throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("Papers", "paperId", Integer.toString(paperId), token);
    }

    /**
     * put method for the paper object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put(Jws<Claims> token) throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("title");
        columnNames.add("abstract");
        columnNames.add("track");
        columnNames.add("status");
        columnNames.add("submissionType");
        columnNames.add("submitterId");
        columnNames.add("fileId");
        columnNames.add("tentativeStatus");
        columnNames.add("paperId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(title);
        values.add(paperAbstract);
        values.add(track);
        values.add(status);
        values.add(Integer.toString(submissionType));
        values.add(Integer.toString(submitterId));
        values.add(fileId);
        values.add(tentativeStatus);
        values.add(Integer.toString(paperId));

        return super.put("Papers", columnNames, values, 1, token);
    }

    /**
     * post method for the paper object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post(Jws<Claims> token) throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("paperId");
        columnNames.add("title");
        columnNames.add("abstract");
        columnNames.add("track");
        columnNames.add("status");
        columnNames.add("submissionType");
        columnNames.add("submitterId");
        columnNames.add("fileId");
        columnNames.add("tentativeStatus");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(paperId));
        values.add(title);
        values.add(paperAbstract);
        values.add(track);
        values.add(status);
        values.add(Integer.toString(submissionType));
        values.add(Integer.toString(submitterId));
        values.add(fileId);
        values.add(tentativeStatus);

        return super.post("Papers", columnNames, values, token);
    }

    /**
     * delete method for the paper object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete(Jws<Claims> token) throws DLException {
        return super.delete("Papers", "paperId", Integer.toString(paperId), token);
    }

    /**
      *
      * Returns all information for the specified paper, excluding filename.
     * However, only admins can retrieve info on any paper--otherwise, the person
     * has to have been an author.
     *
     * @param _paperId is the ID to get information for
     * @param token is the token of the logged-in user attempting to use this function
     * @return a string holding the info about the paper
     *
      *
      */

    public String getPaper(int _paperId, String token) throws DLException {
        String paperInfo = "";

        Users testUser = new Users();

        Jws<Claims> tokenClaims = testUser.decodeToken(token);

        int admin = Integer.parseInt((String) tokenClaims.getBody().get("IsAdmin"));
        int loginUserId = Integer.parseInt((String) tokenClaims.getBody().get("UserID"));
        try {
            MySQLDatabase mysqld = new MySQLDatabase(uName, uPass);

            if (mysqld.connect()) {

                String sqlcheck = "select userId from paperauthors where paperId = ?";
                ArrayList<String> valuescheck = new ArrayList<>();
                valuescheck.add(Integer.toString(_paperId));

                ArrayList<ArrayList<String>> fullresultscheck = mysqld.getData(sqlcheck, valuescheck);
                ArrayList<ArrayList<String>> authorlist = new ArrayList<>();
                for (int i = 2; i < fullresultscheck.size(); i++) {
                    authorlist.add(fullresultscheck.get(i));
                }

                ArrayList<String> loggedinId = new ArrayList<String>();
                loggedinId.add(Integer.toString(loginUserId));

                if (admin == 1 | authorlist.contains(loggedinId)) {
                    String sql0 = "select title, abstract, track, status, submissionType, " +
                            "submitterId, tentativeStatus from papers where paperId = ?";
                    ArrayList<String> values0 = new ArrayList<>();
                    values0.add(Integer.toString(_paperId));

                    ArrayList<ArrayList<String>> fullResults0 = mysqld.getData(sql0, values0);
                    ArrayList<String> results0 = fullResults0.get(2);

                    paperInfo += "Information for paper with ID: " + _paperId;
                    paperInfo += "\nPaper title: " + results0.get(0);
                    paperInfo += "\nPaper abstract: " + results0.get(1);
                    paperInfo += "\nPaper subject(s): ";

                    String sql1 = "select _subjects.subjectname from _subjects join " +
                            "papersubjects on _subjects.subjectid = papersubjects.subjectid " +
                            "join papers on papersubjects.paperid = papers.paperid AND " +
                            "papers.paperid = ?;";
                    ArrayList<String> values1 = new ArrayList<>();
                    values1.add(Integer.toString(_paperId));

                    ArrayList<ArrayList<String>> fullResults1 = mysqld.getData(sql1, values1);
                    ArrayList<ArrayList<String>> results1 = new ArrayList<ArrayList<String>>();
                    for (int i = 2; i < fullResults1.size(); i++) {
                        results1.add(fullResults1.get(i));
                    }

                    if (results1.size() > 1) {
                        for (int i = 0; i < results1.size() - 1; i++) {
                            ArrayList<String> subject = results1.get(i);
                            paperInfo += subject.get(0) + ", " + subject.get(1) + "; ";
                        }
                        ArrayList<String> finalsubject = results1.get(results1.size() - 1);
                        paperInfo += finalsubject.get(0) + ", " + finalsubject.get(1);
                    } else {
                        ArrayList<String> subject = results1.get(0);
                        paperInfo += subject.get(0);
                    }

                    paperInfo += "\nPaper author(s): ";

                    String sql2 = "select users.lastname, users.firstname from " +
                            "users inner join paperauthors on users.userid = " +
                            "paperauthors.userid inner join papers on paperauthors.paperid " +
                            "= papers.paperid and papers.paperid = ?;";
                    ArrayList<String> values2 = new ArrayList<>();
                    values2.add(Integer.toString(_paperId));

                    ArrayList<ArrayList<String>> fullResults2 = mysqld.getData(sql2, values2);
                    ArrayList<ArrayList<String>> results2 = new ArrayList<ArrayList<String>>();
                    for (int i = 2; i < fullResults2.size(); i++) {
                        results2.add(fullResults2.get(i));
                    }

                    if (results2.size() > 1) {
                        for (int i = 0; i < results2.size() - 1; i++) {
                            ArrayList<String> name = results2.get(i);
                            paperInfo += name.get(0) + ", " + name.get(1) + "; ";
                        }
                        ArrayList<String> finalname = results2.get(results2.size() - 1);
                        paperInfo += finalname.get(0) + ", " + finalname.get(1);
                    } else {
                        ArrayList<String> author = results2.get(0);
                        paperInfo += author.get(0) + ", " + author.get(1);
                    }


                    paperInfo += "\nPaper track: " + results0.get(2);

                    paperInfo += "\nPaper status: " + results0.get(3);

                    paperInfo += "\nPaper submission type: ";

                    String sql2point5 = "select typeName from _types where typeId = ?;";
                    ArrayList<String> values2point5 = new ArrayList<String>();
                    values2point5.add(results0.get(4));

                    ArrayList<ArrayList<String>> results2point5 = mysqld.getData(sql2point5, values2point5);
                    paperInfo += results2point5.get(2).get(0);


                    paperInfo += "\nSubmitter: ";

                    String sql3 = "select lastname, firstname from users where userid = ?;";
                    ArrayList<String> values3 = new ArrayList<String>();
                    values3.add(results0.get(5));

                    ArrayList<ArrayList<String>> fullResults3 = mysqld.getData(sql3, values3);
                    ArrayList<ArrayList<String>> results3 = new ArrayList<ArrayList<String>>();

                    for (int i = 2; i < fullResults3.size(); i++) {
                        results3.add(fullResults3.get(i));
                    }

                    paperInfo += results3.get(0).get(0) + ", " + results3.get(0).get(1);

                    paperInfo += "\nTentative status: " + results0.get(6);
                } else {
                    paperInfo += "You cannot retrieve information on this paper. You can only retrieve information on papers you worked on if you are not an admin.";
                }
                mysqld.close();
            }
        } catch (Exception e) {
            System.out.println("Paper information could not be retrieved.");
            throw new DLException(e);
        }

        return paperInfo;
    }

    /**
      *
      * Sets the current paper to the information provided. If a paperId is not currently
      * set, a new paper is created and added to the database. If a paperId is set, the
      * information about the paper is updated. However, only admins and people who have worked on
     * the paper are allowed to upload/edit them.
     *
     * @param _paperId is the new ID of the paper
     * @param _title is the title of the paper
     * @param _paperAbstract is the new abstract of the paper
     * @param _submissionType is the type of submission
     * @param filename is the filename of the paper
     * @param coauthorIds is an array of co-author IDs associated with the paper
     * @param subjectIds is an array of subject IDs associated with the paper
     * @param token is the token from the currently logged-in user
      *
      */
    public void setPaper(int _paperId, String _title, String _paperAbstract, int _submissionType,
                         String filename, int[] subjectIds, int[] coauthorIds, String token) throws DLException {
        MySQLDatabase mysqld = new MySQLDatabase(uName, uPass);

        int paperAuthorCount = coauthorIds.length;
        int paperSubjectCount = subjectIds.length;

        Users testUser = new Users();

        Jws<Claims> tokenClaims = testUser.decodeToken(token);

        int admin = Integer.parseInt((String) tokenClaims.getBody().get("IsAdmin"));
        int loginUserId = Integer.parseInt((String) tokenClaims.getBody().get("UserID"));

        // set info of this object to new values
        setPaperId(_paperId);
        setTitle(_title);
        setPaperAbstract(_paperAbstract);
        setSubmissionType(_submissionType);
        setSubmitterId(loginUserId);
        setFileId(filename);

        if (_paperId == 0) { // create new paper
            boolean submitterIsCoauthor = false;

            // see if submitter is one of the authors of new paper
            for (int i = 0; i < coauthorIds.length; i++) {
                if (loginUserId == coauthorIds[i]) {
                    submitterIsCoauthor = true;
                }
            }

            if (admin == 1 | submitterIsCoauthor) {
                try {
                    mysqld.connect();
                    mysqld.startTrans();

                    String sql0 = "SELECT MAX(paperId) from papers;";
                    ArrayList<String> values0 = new ArrayList<>();

                    ArrayList<ArrayList<String>> fullResults0 = mysqld.getData(sql0, values0);
                    ArrayList<String> results0 = fullResults0.get(2);

                    setPaperId(Integer.parseInt(results0.get(0)) + 1);

                    String sql1 = "INSERT INTO papers (paperId, title, abstract, submissionType, submitterId, fileId) VALUES (?, ?, ?, ?, ?, ?);";
                    ArrayList<String> values1 = new ArrayList<String>();

                    // add new values to array
                    values1.add("" + getPaperId());
                    values1.add(_title);
                    values1.add(_paperAbstract);
                    values1.add(Integer.toString(_submissionType));
                    values1.add(Integer.toString(loginUserId));
                    values1.add(filename);

                    // insert new item into papers
                    mysqld.setData(sql1, values1);

                    // insert new item(s) into papersubjects
                    for (int subjectId : subjectIds) {
                        String sql2 = "INSERT INTO paperSubjects (paperId, subjectId) values (?, ?);";
                        ArrayList<String> values2 = new ArrayList<String>();

                        values2.add(Integer.toString(getPaperId()));
                        values2.add(Integer.toString(subjectId));

                        mysqld.setData(sql2, values2);
                    }

                    // insert new item(s) into paperauthors
                    for (int coauthorId : coauthorIds) {
                        String sql3 = "INSERT INTO paperAuthors (paperId, userId) values (?, ?);";
                        ArrayList<String> values3 = new ArrayList<String>();

                        values3.add(Integer.toString(getPaperId()));
                        values3.add(Integer.toString(coauthorId));

                        mysqld.setData(sql3, values3);
                    }

                    // end transaction
                    mysqld.endTrans();
                    mysqld.close();
                } catch (Exception e) {
                    System.out.println("Paper info could not be set.");
                    mysqld.rollbackTrans();
                    mysqld.close();
                    throw new DLException(e);
                }
            } else {
                System.out.println("You are trying to submit a paper you didn't work on! Please only submit papers you have worked on.");
            }
        } else { // update existing paper
            boolean submitterIsCoauthor = false;

            // GET LIST OF PEOPLE WHO WORKED ON PAPER AND SEE IF ANY OF THEM ARE THE LOGGED IN USER
            try {
                mysqld.connect();
                String sql = "select userId from paperauthors where paperId = ?;";
                ArrayList<String> values = new ArrayList<>();
                values.add(Integer.toString(_paperId));

                ArrayList<ArrayList<String>> fullresults = mysqld.getData(sql, values);
                ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();

                for (int i = 2; i < fullresults.size(); i++) {
                    results.add(fullresults.get(i));
                }

                for (int i = 0; i < results.size(); i++) {
                    if (loginUserId == Integer.parseInt(results.get(i).get(0))) {
                        submitterIsCoauthor = true;
                    }
                }

                mysqld.close();
            } catch (Exception e) {
                System.out.println("Could not retrieve info on the people who made this paper. Therefore, the paper could not be edited.");
                throw new DLException(e);
            }

            if (admin == 1 || submitterIsCoauthor) {
                try {
                    mysqld.connect();
                    mysqld.startTrans();

                    String sql1 = "UPDATE PAPERS SET title = ?, abstract = ?, submissionType = ?, submitterId = ?, fileId = ? WHERE paperId = ?;";
                    ArrayList<String> values1 = new ArrayList<String>();

                    values1.add(_title);
                    values1.add(_paperAbstract);
                    values1.add(_submissionType + "");
                    values1.add(loginUserId + "");
                    values1.add(filename);
                    values1.add(_paperId + "");

                    mysqld.setData(sql1, values1);

                    // delete obsolete data from papersubjects and paperauthors
                    String sql2 = "DELETE from papersubjects WHERE paperId = ?;";
                    String sql3 = "DELETE from paperauthors WHERE paperId = ?;";

                    ArrayList<String> values2 = new ArrayList<String>();
                    values2.add(Integer.toString(_paperId));
                    ArrayList<String> values3 = values2;

                    mysqld.setData(sql2, values2);
                    mysqld.setData(sql3, values3);

                    // update papersubjects
                    for (int subjectId : subjectIds) {
                        String sql4 = "INSERT INTO papersubjects (paperId, subjectId) VALUES (?, ?);";
                        ArrayList<String> values4 = new ArrayList<String>();

                        values4.add(Integer.toString(getPaperId()));
                        values4.add(Integer.toString(subjectId));

                        mysqld.setData(sql4, values4);
                    }

                    // update paperauthors
                    for (int coauthorId : coauthorIds) {
                        String sql5 = "INSERT INTO paperauthors (paperId, userId) VALUES (?, ?);";
                        ArrayList<String> values5 = new ArrayList<String>();

                        values5.add(Integer.toString(getPaperId()));
                        values5.add(Integer.toString(coauthorId));

                        mysqld.setData(sql5, values5);
                    }

                    mysqld.endTrans();
                    mysqld.close();
                } catch (Exception e) {
                    System.out.println("Paper info could not be updated.");
                    mysqld.rollbackTrans();
                    mysqld.close();
                    throw new DLException(e);
                }
            } else {
                System.out.println("You cannot update information on this paper. If you are not an author, you must be an admin.");
            }
        }

    }

} // end Papers