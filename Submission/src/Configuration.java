import java.util.*;

public class Configuration {
      
    // table attributes
    private Date submissionOpen;
    private Date submissionClose;
    private String PCEmail;
    private String PCName;
    private String PC2Email;
    private String PC2Name;
    private String shortName;
    private String logoFile;

    public Date getSubmissionOpen() {
        return submissionOpen;
    }

    public void setSubmissionOpen(Date submissionOpen) {
        this.submissionOpen = submissionOpen;
    }

    public Date getSubmissionClose() {
        return submissionClose;
    }

    public void setSubmissionClose(Date submissionClose) {
        this.submissionClose = submissionClose;
    }

    public String getPCEmail() {
        return PCEmail;
    }

    public void setPCEmail(String PCEmail) {
        this.PCEmail = PCEmail;
    }

    public String getPCName() {
        return PCName;
    }

    public void setPCName(String PCName) {
        this.PCName = PCName;
    }

    public String getPC2Email() {
        return PC2Email;
    }

    public void setPC2Email(String PC2Email) {
        this.PC2Email = PC2Email;
    }

    public String getPC2Name() {
        return PC2Name;
    }

    public void setPC2Name(String PC2Name) {
        this.PC2Name = PC2Name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
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

} // end Configuration