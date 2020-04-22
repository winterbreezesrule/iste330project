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
    private String tenativeStatus;

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
     * Gets the tenative status of the paper.
     * @return the tenative status of the paper.
     */
    public String getTenativeStatus() {
        return tenativeStatus;
    }

    /**
     * Sets the tenative status of the paper.
     * @param tenativeStatus is the new tenative status.
     */
    public void setTenativeStatus(String tenativeStatus) {
        this.tenativeStatus = tenativeStatus;
    }

    /**
     * fetch method for the paper object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
     *
     * @throws DLException custom exception that logs errors in a separate file
     */
    public void fetch() throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("Papers", "paperId", Integer.toString(paperId));
    }

    /**
     * put method for the paper object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
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
        values.add(tenativeStatus);
        values.add(Integer.toString(paperId));

        return super.put("Users", columnNames, values);
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
        values.add(tenativeStatus);

        return super.post("Users", columnNames, values);
    }

    /**
     * delete method for the paper object. Passes info from this class
     * to the superclass post method, where the query is created and executed.
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

            String sql0 = "select title, abstract, submissionType from papers where paperid = ?";
            ArrayList<String> values0 = new ArrayList<>();
            values0.add(Integer.toString(_paperId));

            ArrayList<ArrayList<String>> fullResults0 = mysqld.getData(sql0, values0);
            ArrayList<String> results0 = fullResults0.get(2);

            paperInfo += "Paper title: " + results0.get(0);
            paperInfo += "\nPaper abstract: " + results0.get(1);
            paperInfo += "\nPaper submission type: " + results0.get(2);
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
      */
    public void setPaper(int _paperId, String _title, String _paperAbstract, int _submissionType,
                         String filename, String[] subjects, String[] coauthorsFirstNames, String[]
                         coauthorsLastNames) {
        // check to see if subject(s) exist in _subjects
        // check to see if authors exist in _users

        // if paperId = 0 make new paper
        // INSERT INTO papers (paperId, title, abstract, submissionType) VALUES (?, ?, ?, ?);
        // otherwise update current paper
        // UPDATE PAPERS SET title = ?, abstract = ?, submissionType = ? WHERE paperId = ?;

        // need to also update paperauthors and papersubjects
        // IS THIS A TRANSACTION?

    }

} // end Papers