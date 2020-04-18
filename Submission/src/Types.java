/**
 * Used to represent the _Types table in the CSM database.
 */

public class Types {

    // table attributes
    private int typeId;
    private String typeName;

    /**
     * Get the type ID.
     * @return the type ID.
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set the type ID.
     * @param typeId is the new type ID.
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * Get the type name.
     * @return the type name.
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Set the type name.
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

} // end Types