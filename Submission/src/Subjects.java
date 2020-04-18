/**
 * Used to represent the Subjects table in the CSM database.
 */
public class Subjects {

    // table attributes
    private int subjectId;
    private String subjectName;

    /**
     * Gets the subject ID.
     * @return the subject ID.
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Sets the subject ID.
     * @param subjectId is the new subject ID.
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Gets the subject name.
     * @return the new subject name.
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name.
     * @param subjectName is the new subject name.
     */
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