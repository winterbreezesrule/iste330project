public class Subjects {

    // table attributes
    private int subjectId;
    private String subjectName;
      
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

} // end Subjects 