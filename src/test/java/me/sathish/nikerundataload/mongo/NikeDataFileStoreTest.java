package me.sathish.nikerundataload.mongo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NikeDataFileStoreTest {
    @Autowired
    NikeDataFileStore nikeDataFileStore;


    @Test
    void testConnectMongoDB() {
        nikeDataFileStore.ConnectMongoDB();
    }
}
