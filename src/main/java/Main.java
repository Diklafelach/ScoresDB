import mongo.Connection;

public class Main {

    public static void main(String[] args){

        var client = new Connection("mongodb://host1:27017");
        client.connect();
    }

}