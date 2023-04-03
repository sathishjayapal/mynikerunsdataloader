package me.sathish.nikerundataload.loader.service;

import me.sathish.nikerundataload.loader.jpa.NikeRunsDataDTO;
import me.sathish.nikerundataload.loader.jpa.NikeRunsDataRepo;
import me.sathish.nikerundataload.loader.parser.NikeActivityParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NikeRunApiService {
    private static final Logger logger = LoggerFactory.getLogger(NikeRunApiService.class);
    @Autowired
    NikeRunsDataRepo nikeRunsDataRepo;
    @Autowired
    NikeActivityParser nikeActivityParser;

    public void SaveNikeRunApi() {
        List nikeRunsList = nikeActivityParser.parseJSONData();
        nikeRunsDataRepo.saveAll(nikeRunsList);
    }

    @Transactional(readOnly = true)
    public NikeRunsDataDTO getPaginatedNikeRunsData(Integer page) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "id");
        Page nikeRunsDataPage = nikeRunsDataRepo.findAll(pageable);
        NikeRunsDataDTO nikeRunsDataDTO = new NikeRunsDataDTO(nikeRunsDataPage.getContent(), nikeRunsDataPage.getTotalElements(), nikeRunsDataPage.getTotalPages(), nikeRunsDataPage.getNumber(), nikeRunsDataPage.isLast(), nikeRunsDataPage.isFirst(), nikeRunsDataPage.hasNext(), nikeRunsDataPage.hasPrevious());
        return nikeRunsDataDTO;
    }
}
