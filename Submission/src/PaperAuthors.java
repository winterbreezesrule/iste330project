public class PaperAuthors {

    // table attributes
    private int paperId;
    private int userId;
    private int displayOrder;
      
    /**
      *
      * ACCESSORS AND MUTATORS GO HERE
      *
      */
    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    /**
      *
      * CRUD METHODS GO HERE
      *
      */

} // end PaperAuthors