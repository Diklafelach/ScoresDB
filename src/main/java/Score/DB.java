package Score;

import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Updates.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mongo.Connection;
import org.bson.Document;

public class DB {

    private final MongoDatabase _database;
    private final MongoCollection<Document> _score;

    public DB(Connection connection,String databaseName)
    {
        //getting the access for the db
        _database= connection.GetDatabase(databaseName);
        //getting the collection
        _score = _database.getCollection("ScorePlayer");
    }
    //to insert  to db we must insert a document
    public void AddPlayer(ScorePlayer score)
    {
        _score.insertOne(score.toDocument());
    }
    //check if the player exist
    public  boolean exist(String name)
    {
        var answer = _score.find(Filters.eq("_fullname",name)).first();
        return answer != null;
    }

    public void AddingScore( ScorePlayer scorePlayer, int points)
    {
        int newPoints = scorePlayer.getScore()+points;
        Document search = new Document("_fullname",scorePlayer.getFullname());
        BasicDBObject set = new BasicDBObject("$set", new BasicDBObject("_score", newPoints));
        if(exist(scorePlayer.getFullname())){
            // We update some fields of the documents without affecting the rest
              _score.updateOne(search,set);
              scorePlayer.setScore(newPoints);
        }


    }

}
