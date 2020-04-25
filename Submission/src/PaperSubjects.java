import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.ArrayList;

/**
 * Used to represent the PaperSubjects table in the CSM database.
 */
public class PaperSubjects extends DLObject{

    // attributes
    private int paperId;
    private int subjectId;

    /**
     * Gets the paper ID.
     * @return the paper ID.
     */
    public int getPaperId() {
        return paperId;
    }

    /**
     * Sets the paper ID.
     * @param paperId is the new paper ID.
     */
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

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

    public void fetch(Jws<Claims> token) throws DLException {
        // add primary key to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("paperId");
        pkNames.add("subjectId");

        // add primary key data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(paperId));
        pkData.add(Integer.toString(subjectId));

        ArrayList<ArrayList<String>> data = super.fetch("PaperSubjects", pkNames, pkData, token);

        try {
            setPaperId(Integer.parseInt(data.get(2).get(0)));
            setSubjectId(Integer.parseInt(data.get(2).get(1)));
        } catch (Exception e) {
            System.out.println("Information could not be applied to this object.");
            throw new DLException(e);
        }
    }

    public int put(Jws<Claims> token) throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("paperId");
        columnNames.add("subjectId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(paperId));
        values.add(Integer.toString(subjectId));

        return super.put("PaperSubjects", columnNames, values, 1, token);
    }

    public int post(Jws<Claims> token) throws DLException {
        // putting all of the column names into an ArrayList for passing to the superclass method
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("subjectId");
        columnNames.add("paperId");

        // putting all of the object values into an ArrayList for passing to the superclass method
        ArrayList<String> values = new ArrayList<>();
        values.add(Integer.toString(subjectId));
        values.add(Integer.toString(paperId));

        return super.put("PaperSubjects", columnNames, values, 1, token);
    }

    public int delete(Jws<Claims> token) throws DLException {
        // add primary key to ArrayList for passing into superclass method
        ArrayList<String> pkNames = new ArrayList<>();
        pkNames.add("paperId");
        pkNames.add("subjectId");

        // add primary key data to ArrayList for passing into superclass method
        ArrayList<String> pkData = new ArrayList<>();
        pkData.add(Integer.toString(paperId));
        pkData.add(Integer.toString(subjectId));

        return super.delete("PaperSubjects", pkNames, pkData, token);
    }

} // end PaperSubjects