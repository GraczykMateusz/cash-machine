package dev.graczykmateusz.cashmachine.boot;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

class MongoConfig {

  public static void main(String[] args) {
    String connectionString = ""; //todo
    ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
    MongoClientSettings settings =
        MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(connectionString))
            .serverApi(serverApi)
            .build();
    // Create a new client and connect to the server
    try (MongoClient mongoClient = MongoClients.create(settings)) {
      try {
        // Send a ping to confirm a successful connection
        mongoClient.listDatabaseNames().forEach(System.out::println);
        MongoDatabase database = mongoClient.getDatabase("cash-machine");
        //                database.runCommand(new Document("ping", 1));
        database.createCollection("x");
        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
      } catch (MongoException e) {
        e.printStackTrace();
      }
    }
  }
}
