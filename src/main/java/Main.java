import Score.DB;
import Score.ScorePlayer;
import mongo.Connection;

public class Main {

    public static void main(String[] args){

        var client = new Connection("mongodb://127.0.0.1:27017");
        client.connect();
        var DB = new DB(client,"Scores");
        if(!DB.exist("Dikla Felach")) {
            DB.AddScore(new ScorePlayer(10, "Dikla Felach"));
        }


    }

}