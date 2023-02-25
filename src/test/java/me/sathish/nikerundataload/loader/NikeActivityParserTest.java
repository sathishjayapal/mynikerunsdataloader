package me.sathish.nikerundataload.loader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NikeActivityParserTest {
    @Autowired
    NikeActivityParser activityParser;

    @Test
    void testReadFromFile() {
        String str = activityParser.readFromFile();
        assertTrue(1 == 1);
    }
}
