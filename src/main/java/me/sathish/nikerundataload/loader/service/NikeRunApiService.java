package me.sathish.nikerundataload.loader.service;

import lombok.RequiredArgsConstructor;
import me.sathish.nikerundataload.loader.jpa.NikeRunsDataDTO;
import me.sathish.nikerundataload.loader.jpa.NikeRunsDataRepo;
import me.sathish.nikerundataload.loader.util.NikeActivityParser;
import me.sathish.nikerundataload.loader.util.NikeRunsDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NikeRunApiService {
    private static final Logger logger = LoggerFactory.getLogger(NikeRunApiService.class);
    private final NikeRunsDataRepo nikeRunsDataRepo;
    private final NikeActivityParser nikeActivityParser;

    private final NikeRunsDataMapper nikeRunsDataMapper;

    public void SaveNikeRunApi() {
        List nikeRunsList = nikeActivityParser.parseJSONData();
        nikeRunsDataRepo.saveAll(nikeRunsList);
    }

    @Transactional(readOnly = true)
    public NikeRunsDataDTO getPaginatedNikeRunsData(Integer page, Integer numberOfElements) {
        int pageNumber = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNumber, numberOfElements, Sort.Direction.DESC, "id");
        Page nikeRunsDataPage = nikeRunsDataRepo.findAll(pageable).
                map(nikeRunsDBData -> nikeRunsDataMapper.toDTO(nikeRunsDBData));
        NikeRunsDataDTO nikeRunsDataDTO = new NikeRunsDataDTO(nikeRunsDataPage.getTotalElements(),
                nikeRunsDataPage.getTotalPages(), nikeRunsDataPage.getNumber(),
                nikeRunsDataPage.isLast(), nikeRunsDataPage.isFirst(), nikeRunsDataPage.hasNext(),
                nikeRunsDataPage.hasPrevious(), nikeRunsDataPage.getContent());
        return nikeRunsDataDTO;
    }
}
