//package dev.graczykmateusz.cashmachine.boot;
//
//import com.mongodb.*;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.connection.ConnectionPoolSettings;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//class MongoConfiguration extends AbstractMongoClientConfiguration {
//
//  @Override
//  public MongoClient mongoClient() {
//    ConnectionString connectionString = new ConnectionString(String.format(CONNECTION_STRING, host, port, database));
//    MongoClientSettings clientSettings = MongoClientSettings.builder()
//            .retryWrites(true)
//            .applyConnectionString(connectionString)
//            .applyToConnectionPoolSettings((ConnectionPoolSettings.Builder builder) -> {
//              builder.maxSize(100) //connections count
//                      .minSize(5)
//                      .maxConnectionLifeTime(30, TimeUnit.MINUTES)
//                      .maxConnectionIdleTime( maxIdleTime, TimeUnit.MILLISECONDS);
//            })
//            .applyToSocketSettings(builder -> {
//              builder.connectTimeout(2000, TimeUnit.MILLISECONDS);
//            })
//            .applicationName(appName)
//            .build();
//
//    return MongoClients.create(clientSettings);
//  }
//
//  @Override
//  protected String getDatabaseName() {
//    return "";
//  }
//}
