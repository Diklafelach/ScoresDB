package Score;
import org.bson.Document;

public class ScorePlayer {
    private String score;

    public ScorePlayer(String score){

        this.score = score;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    // casting to document
    public Document toDocument() {
        return new Document().append("_score",score);
    }
}
