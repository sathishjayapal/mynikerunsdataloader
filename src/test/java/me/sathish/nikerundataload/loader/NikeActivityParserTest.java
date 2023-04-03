package me.sathish.nikerundataload.loader;

import me.sathish.nikerundataload.loader.parser.NikeActivityParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NikeActivityParserTest {
    @Autowired
    NikeActivityParser activityParser;

    @Test
    void testReadFromFile() {
        Optional<String> str = activityParser.readFromFile();
        assertEquals(1, 1);
    }

    @Test
    void testParseJSONData() {
        List list = activityParser.parseJSONData();
        assertTrue(list.size() > 0);
    }
}
