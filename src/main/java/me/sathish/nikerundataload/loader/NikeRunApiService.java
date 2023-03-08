package me.sathish.nikerundataload.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NikeRunApiService {
    private static final Logger logger = LoggerFactory.getLogger(NikeRunApiService.class);
    @Autowired
    NikeRunsRepo nikeRunsRepo;
    @Autowired
    NikeActivityParser nikeActivityParser;

    public void SaveNikeRunApi() {
        List nikeRunsList = nikeActivityParser.parseJSONData();
        nikeRunsRepo.saveAll(nikeRunsList);
    }
}
