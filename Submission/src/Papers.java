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
            fetch();
            paperInfo += "Paper title: " + getTitle();
            paperInfo += "\nPaper abstract: " + getPaperAbstract();
            paperInfo += "\nPaper track: " + getTrack();
            paperInfo += "\nPaper status: " + getStatus();
            paperInfo += "\nPaper submission type: " + getSubmissionType();
            paperInfo += "\nPaper submitter ID: " + getSubmitterId();
            paperInfo += "\nPaper tenative status: " + getTenativeStatus();
        } catch (Exception e) {
            // I hate my life.
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