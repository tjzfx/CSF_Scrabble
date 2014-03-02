public class LetterTile {
    private String letter;
    private int pointValue;
    private int numInstances;
    private int tileRow;
    private int tileCol;
    private String bonusValue;


    private Boolean committed;

    public LetterTile(String letter, int pointValue){
        this.letter = letter;
        this.pointValue = pointValue;
        //this.numInstances = numInstances;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        LetterTile that = (LetterTile) o;
//
//        if (numInstances != that.numInstances) return false;
//        if (pointValue != that.pointValue) return false;
//        if (!letter.equals(that.letter)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = letter.hashCode();
//        result = 31 * result + pointValue;
//        result = 31 * result + numInstances;
//        return result;
//    }

    public String toString(){
        String letterTileInfo = "Letter is " + this.getLetter() +  " and point val is " + this.getPointValue();
        return letterTileInfo;
    }

    // need to be able to get a letter tile from a letter that someone plays
//    public LetterTile getLetterTileFromLetter(String s){
//        if (this.getLetter() == s){
//            return this;
//        }
//        return null;
//    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public void setNumInstances(int numInstances) {
        this.numInstances = numInstances;
    }

    public int getTileRow() {
        return tileRow;
    }

    public void setTileRow(int tileRow) {
        this.tileRow = tileRow;
    }

    public int getTileCol() {
        return tileCol;
    }

    public void setTileCol(int tileCol) {
        this.tileCol = tileCol;
    }

    public String getBonusValue() {
        return bonusValue;
    }

    public void setBonusValue(String bonusValue) {
        this.bonusValue = bonusValue;
    }

    public boolean getCommitted() {
        return committed;
    }

    public void setCommitted(boolean committed) {
        this.committed = committed;
    }

}

// point value, and num instances of each letter are determined by the txt file