import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.*;

/**
 * Used to represent the _Configuration table in the CSM database.
 */

public class Configuration extends DLObject{
      
    // table attributes
    private Date submissionOpen;
    private Date submissionClose;
    private String PCEmail;
    private String PCName;
    private String PC2Email;
    private String PC2Name;
    private String shortName;
    private String logoFile;

    /**
     * Get the date the submission was opened.
     * @return the date the submission was opened.
     */
    public Date getSubmissionOpen() {
        return submissionOpen;
    }

    /**
     * Set the date the submission was opened.
     * @param submissionOpen is the new date.
     */
    public void setSubmissionOpen(Date submissionOpen) {
        this.submissionOpen = submissionOpen;
    }

    /**
     * Get the date the submission was closed.
     * @return the date the submission was closed.
     */
    public Date getSubmissionClose() {
        return submissionClose;
    }

    /**
     * Set the date the submission was closed.
     * @param submissionClose is the new date.
     */
    public void setSubmissionClose(Date submissionClose) {
        this.submissionClose = submissionClose;
    }

    /**
     * Get the email associated with the PC.
     * @return the PC email.
     */
    public String getPCEmail() {
        return PCEmail;
    }

    /**
     * Set the email associated with the PC.
     * @param PCEmail is the new PC email.
     */
    public void setPCEmail(String PCEmail) {
        this.PCEmail = PCEmail;
    }

    /**
     * Get the name associated with the PC.
     * @return the PC's name.
     */
    public String getPCName() {
        return PCName;
    }

    /**
     * Set the name associated with the PC.
     * @param PCName is the new name.
     */
    public void setPCName(String PCName) {
        this.PCName = PCName;
    }

    /**
     * Get the second email associated with the PC.
     * @return the second email.
     */
    public String getPC2Email() {
        return PC2Email;
    }

    /**
     * Set the second email associated with the PC.
     * @param PC2Email is the second email.
     */
    public void setPC2Email(String PC2Email) {
        this.PC2Email = PC2Email;
    }

    /**
     * Get the second name associated with the PC.
     * @return the second name.
     */
    public String getPC2Name() {
        return PC2Name;
    }

    /**
     * Set the second name associated with the PC.
     * @param PC2Name is the second name of the PC
     */
    public void setPC2Name(String PC2Name) {
        this.PC2Name = PC2Name;
    }

    /**
     * Get the short name of the PC.
     * @return the short name.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Set the short name of the PC.
     * @param shortName is the new short name.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Get the logo file.
     * @return the logo file.
     */
    public String getLogoFile() {
        return logoFile;
    }

    /**
     * Set the logo file.
     * @param logoFile is the new logo file.
     */
    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }

    public void fetch(Jws<Claims> token) throws DLException {
        ArrayList<ArrayList<String>> data = super.fetch("_Configuration", token);
    }

    public int put() throws DLException {
        return 1;
    }

    public int post() throws DLException {
        return 1;
    }

    public int delete() throws DLException {
        return 1;
    }

} // end Configuration