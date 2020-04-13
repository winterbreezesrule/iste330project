import java.util.*;

public class Papers {

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
      
    // accessors and mutators
    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(int submissionType) {
        this.submissionType = submissionType;
    }

    public int getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(int submitterId) {
        this.submitterId = submitterId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getTenativeStatus() {
        return tenativeStatus;
    }

    public void setTenativeStatus(String tenativeStatus) {
        this.tenativeStatus = tenativeStatus;
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
      * Returns all information for the specified paper, excluding filename.
     *
     * @param _paperId is the ID to get information for
     * @return a string holding the info about the paper
     *
      *
      */

    public String getPaper(int _paperId) throws DLException {
        String paperInfo = "";
        setPaperId(_paperId);
        try {
            MySQLDatabase mysqld = new MySQLDatabase("root", "USO800rubysky#1!");

            // make sure youre getting info about right paper. do you need this?
            // idk
            fetch();

            // NEED TO GET:
            // PAPER TITLE
            // PAPER ABSTRACT
            // PAPER SUBMISSION TYPE
            // PAPER SUBJECT(S)
            // PAPER AUTHORS (FIRST AND LAST NAMES)

            paperInfo += "Paper title: " + getTitle();
            paperInfo += "\nPaper abstract: " + getPaperAbstract();
            paperInfo += "\nPaper submission type: " + getSubmissionType();
            paperInfo += "\nPaper subject(s): ";

            String sql1 = "select _subjects.subjectname from _subjects join " +
                    "papersubjects on _subjects.subjectid = papersubjects.subjectid " +
                    "join papers on papersubjects.paperid = papers.paperid AND " +
                    "papers.paperid = ?;";
            ArrayList<String> values1 = new ArrayList<>();
            values1.add(Integer.toString(getPaperId()));

            ArrayList<ArrayList<String>> fullResults1 = mysqld.getData(sql1, values1);
            ArrayList<ArrayList<String>> results1 = new ArrayList<ArrayList<String>>();
            for (ArrayList<String> strings : fullResults1) {
                results1.add(strings);
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
            values2.add(Integer.toString(getPaperId()));

            ArrayList<ArrayList<String>> fullResults2 = mysqld.getData(sql2, values2);
            ArrayList<ArrayList<String>> results2 = new ArrayList<ArrayList<String>>();

            for (ArrayList<String> strings : fullResults2) {
                results2.add(strings);
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
      * setPaper() GOES HERE
      *
      */
    public void setPaper(int _paperId, String _title, String _paperAbstract, int _submissionType,
                         String filename, String[] subjects, String[] coauthorsFirst, String[]
                         coauthorsLast) {

    }

} // end Papers