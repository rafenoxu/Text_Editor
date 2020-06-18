package editor;

public class Match {

    private int index;
    private String word;

    public Match(int index, String word) {
        this.index = index;
        this.word = word;
    }

    public int getIndex() {
        return index;
    }

    public String getWord() {
        return word;
    }
}
