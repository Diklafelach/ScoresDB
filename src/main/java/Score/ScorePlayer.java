package Score;
import org.bson.Document;

public class ScorePlayer {
    private int score;
    private String fullName;
    public ScorePlayer(int score, String fullname){

        this.score = score;
        this.fullName = fullname;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    // casting to document
    public Document toDocument() {
        return new Document().append("_score",score)
                .append("_fullname",fullName);

    }

}
