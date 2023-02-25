package me.sathish.nikerundataload.loader;

import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
@ConfigurationProperties(prefix = "nikerun.default")
public class NikeActivityParser {
    private static final Logger logger = LoggerFactory.getLogger(NikeActivityParser.class);

//    public void parseToObjects() {
//
//        JSONArray jsonArray = new JSONArray(json);
//    }

    private File defaultFile;

    public File getDefaultFile() {
        return defaultFile;
    }

    public void setDefaultFile(File defaultFile) {
        this.defaultFile = defaultFile;
    }

    public String readFromFile() {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(getDefaultFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (IOException io) {
            logger.error("IO Exception parsing file " + io.toString());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception exception) {
                    logger.error("Exception in finally block " + exception.getMessage());
                }
            }
        }
        return null;
    }
}
