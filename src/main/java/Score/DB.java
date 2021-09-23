package Score;

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
    public void AddScore(ScorePlayer score)
    {
        _score.insertOne(score.toDocument());
    }
    //check if the player exist
    public  boolean exist(String name)
    {
        var answer = _score.find(new Document("fullName",name)).first();
        return answer != null;
    }
}
