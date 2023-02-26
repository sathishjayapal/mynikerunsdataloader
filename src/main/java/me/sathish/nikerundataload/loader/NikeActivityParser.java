package me.sathish.nikerundataload.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.random.RandomGenerator;

@Component
@ConfigurationProperties(prefix = "nikerun")//yml file constains nrefix value
public class NikeActivityParser {
    private static final Logger logger = LoggerFactory.getLogger(NikeActivityParser.class);

    private File defaultFile;

    public File getDefaultFile() {
        return defaultFile;
    }

    public void setDefaultFile(File defaultFile) {
        this.defaultFile = defaultFile;
    }

    public List parseJSONData() {
        Optional<String> fileReadString = readFromFile();
        JacksonJsonParser jsonArray = new JacksonJsonParser();
        String parsedStr = fileReadString.orElseThrow();
        List jsonList = new ArrayList();
        ((List) jsonArray.parseMap(parsedStr).get("activities")).stream().forEach(data -> {
            NikeRunsData runsData = new NikeRunsData();
            runsData.setId(RandomGenerator.getDefault().nextLong());
            runsData.setName((String) ((Map) data).get("id"));
            runsData.setStart_time((Long) ((Map) data).get("start_epoch_ms"));
            runsData.setEnd_time((Long) ((Map) data).get("end_epoch_ms"));
            jsonList.add(runsData);
        });
        return jsonList;
    }

    public Optional<String> readFromFile() {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(getDefaultFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException io) {
            logger.error("IO Exception parsing file " + io);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception exception) {
                    logger.error("Exception in finally block " + exception.getMessage());
                }
            }
        }
        return Optional.ofNullable(builder.toString());
    }
}
