public class LetterTile {
    private String letter;
    private int pointValue;
    private int numInstances;

    public LetterTile(String letter, int pointValue){
        this.letter = letter;
        this.pointValue = pointValue;
        //this.numInstances = numInstances;
    }

    public String toString(){
        String letterTileInfo = "Letter is " + this.getLetter() +  " and point val is " + this.getPointValue();
        return letterTileInfo;
    }

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
}

// point value, and num instances of each letter are determined by the txt file