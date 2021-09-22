package mongo;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class Connection {

    private com.mongodb.client.MongoClient _mongoClient;
    private final ConnectionString cString;

    public Connection(String connectionString) {
        cString = new ConnectionString(connectionString);
    }
    public void connect(){
        _mongoClient = MongoClients.create(cString);
    }
    //getDB return a MongoDB
    public MongoDatabase getDatabase(String DatabaseName){ return _mongoClient.getDatabase(DatabaseName);}





}
