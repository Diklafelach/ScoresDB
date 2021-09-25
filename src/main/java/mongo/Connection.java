package mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class Connection {

    private final MongoClientSettings _settings;
    private com.mongodb.client.MongoClient _mongoClient;
    private final ConnectionString cString;

    public Connection(String connectionString) {
        cString = new ConnectionString(connectionString);
        _settings = MongoClientSettings.builder()
                .applyConnectionString(cString)
                .build();
    }
    public void connect(){
        _mongoClient = MongoClients.create(cString);
    }
    //getDB return a MongoDB
    public MongoDatabase GetDatabase(String DatabaseName){ return _mongoClient.getDatabase(DatabaseName);}





}
