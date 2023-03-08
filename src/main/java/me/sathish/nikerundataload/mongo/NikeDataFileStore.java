package me.sathish.nikerundataload.mongo;

import com.mongodb.client.MongoClient;
import org.springframework.stereotype.Service;

@Service
public class NikeDataFileStore {
    final
    MongoClient mongoClient;

    public NikeDataFileStore(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void ConnectMongoDB() {
        String str = mongoClient.getDatabase("runningfiles").getName();
        System.out.println("The name of the database is " + str);
    }
}
