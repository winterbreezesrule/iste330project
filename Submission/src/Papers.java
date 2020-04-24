import java.util.*;
/**
 * Used to represent the Papers table in the CSM database.
 */

public class Papers extends DLObject{

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
    public void fetch() throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("Papers", "paperId", Integer.toString(paperId));
    }

    /**
     * put method for the paper object. Passes info from this class
     * to the superclass put method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int put() throws DLException {
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

        return super.put("Users", columnNames, values, 1);
    }

    /**
     * post method for the paper object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int post() throws DLException {
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

        return super.post("Users", columnNames, values);
    }

    /**
     * delete method for the paper object. Passes info from this class
     * to the superclass delete method, where the query is created and executed.
     *
     * @return number of rows affected
     * @throws DLException custom exception that logs errors in a separate file
     */
    public int delete() throws DLException {
        return super.delete("Papers", "paperId", Integer.toString(paperId));
    }

    /**
      *
      * Returns all information for the specified paper, excluding filename.
     *
     * @param _paperId is the ID to get information for
     * @return a string holding the info about the paper
     *
      *
      */

    public String getPaper(int _paperId) throws DLException {
        String paperInfo = "";
        try {
            MySQLDatabase mysqld = new MySQLDatabase("root", "USO800rubysky#1!");

            // YOU NEED TO GET EVERYTHING EXCLUDING FILENAME
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
                paperInfo += subject.get(0) + ", " + subject.get(1);
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
            Types tempType = new Types();
            tempType.setTypeId(Integer.parseInt(results0.get(4)));
            tempType.fetch();
            paperInfo += tempType.getTypeName();


            paperInfo += "\nSubmitter: ";
            Users tempUser = new Users();
            tempUser.setUserId(Integer.parseInt(results0.get(5)));
            tempUser.fetch();
            paperInfo += tempUser.getFirstName() + tempUser.getLastName();

            paperInfo += "\nTentative status: " + results0.get(6);

        } catch (Exception e) {
            System.out.println("Paper information could not be retrieved.");
        }

        return paperInfo;
    }

    /**
      *
      * Sets the current paper to the information provided. If a paperId is not currently
      * set, a new paper is created and added to the database. If a paperId is set, the
      * information about the paper is updated.
     *
     * @param _paperId is the new ID of the paper
     * @param _title is the title of the paper
     * @param _paperAbstract is the new abstract of the paper
     * @param _submissionType is the type of submission
     * @param filename is the filename of the paper
     * @param coauthorIds is an array of co-author IDs associated with the paper
     * @param subjectIds is an array of subject IDs associated with the paper
      *
      */
    public void setPaper(int _paperId, String _title, String _paperAbstract, int _submissionType,
                         String filename, int[] subjectIds, int[] coauthorIds) throws DLException {


        MySQLDatabase mysqld = new MySQLDatabase("username", "password");

        int paperAuthorCount = coauthorIds.length;
        int paperSubjectCount = subjectIds.length;

        // HANSEL SUBMITTER ID SHIT HELP ME OUT HERE
        int tempsubid = 0;

        // set info of this object to new values
        setPaperId(_paperId);
        setTitle(_title);
        setPaperAbstract(_paperAbstract);
        setSubmissionType(_submissionType);
        setSubmitterId(tempsubid);
        setFileId(filename);

        if (_paperId == 0) { // create new paper
            try {
                mysqld.connect();
                mysqld.startTrans();

                String sql0 = "SELECT MAX(paperId) from users;";
                ArrayList<String> values0 = new ArrayList<>();

                ArrayList<ArrayList<String>> fullResults0 = mysqld.getData(sql0, values0);
                ArrayList<String> results0 = fullResults0.get(2);

                setPaperId(Integer.parseInt(results0.get(0)));

                String sql1 = "INSERT INTO papers (paperId, title, abstract, submissionType, submitterId, fileId) VALUES (?, ?, ?, ?, ?, ?);";
                ArrayList<String> values1 = new ArrayList<String>();

                // add new values to array
                values1.add("" + getPaperId());
                values1.add(_title);
                values1.add(_paperAbstract);
                values1.add(Integer.toString(_submissionType));
                values1.add(Integer.toString(tempsubid));
                values1.add(filename);

                // insert new item into papers
                mysqld.setData(sql1, values1);

                // insert new item(s) into papersubjects
                for (int subjectId : subjectIds) {
                    String sql2 = "INSERT INTO paperSubjects values ?, ?;";
                    ArrayList<String> values2 = new ArrayList<String>();

                    values2.add("" + _paperId);
                    values2.add("" + subjectId);

                    mysqld.setData(sql2, values2);
                }

                // insert new item(s) into paperauthors
                for (int coauthorId : coauthorIds) {
                    String sql3 = "INSERT INTO paperAuthors values ?, ?;";
                    ArrayList<String> values3 = new ArrayList<String>();

                    values3.add("" + _paperId);
                    values3.add("" + coauthorId);

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

        } else { // update existing paper
            try {
                mysqld.connect();
                mysqld.startTrans();

                String sql1 = "UPDATE PAPERS SET title = ?, abstract = ?, submissionType = ?, submitterId = ?, fileId = ? WHERE paperId = ?;";
                ArrayList<String> values1 = new ArrayList<String>();

                values1.add(_title);
                values1.add(_paperAbstract);
                values1.add(_submissionType + "");
                values1.add(tempsubid + "");
                values1.add(filename);
                values1.add(_paperId + "");

                mysqld.setData(sql1, values1);

                // delete obsolete data from papersubjects and paperauthors
                String sql2 = "DELETE from papersubjects WHERE paperId = ?;";
                String sql3 = "DELETE from paperauthors WHERE paperId = ?;";

                ArrayList<String> values2 = new ArrayList<String>();
                values2.add("" + _paperId);
                ArrayList<String> values3 = values2;

                mysqld.setData(sql2, values2);
                mysqld.setData(sql3, values3);

                // update papersubjects
                for (int subjectId : subjectIds) {
                    String sql4 = "INSERT INTO papersubjects VALUES ?, ?;";
                    ArrayList<String> values4 = new ArrayList<String>();

                    values4.add("" + _paperId);
                    values4.add("" + subjectId);

                    mysqld.setData(sql4, values4);
                }

                // update paperauthors
                for (int coauthorId : coauthorIds) {
                    String sql5 = "INSERT INTO paperauthors VALUES ?, ?;";
                    ArrayList<String> values5 = new ArrayList<String>();

                    values5.add("" + _paperId);
                    values5.add("" + coauthorId);

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
        }

    }

} // end Papers