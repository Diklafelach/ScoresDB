import Score.DB;
import Score.ScorePlayer;
import mongo.Connection;

public class Main {

    public static void main(String[] args){
        ScorePlayer PlayerOne = null;
        var client = new Connection("mongodb://127.0.0.1:27017");
        client.connect();
        var DB = new DB(client,"Scores");

        boolean answer = DB.exist("Dikla Felach");
        if(!answer) {
            PlayerOne = new ScorePlayer(0,"Dikla Felach");
            DB.AddPlayer(PlayerOne);
        }
        if(PlayerOne==null)
        {
            PlayerOne = new ScorePlayer(0,"Dikla Felach");
            DB.UpdatingScore(PlayerOne, 10);
        }
        DB.Delete(PlayerOne.getFullname());



    }

}