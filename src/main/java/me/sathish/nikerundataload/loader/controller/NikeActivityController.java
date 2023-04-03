package me.sathish.nikerundataload.loader.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sathish.nikerundataload.loader.jpa.NikeRunsDataDTO;
import me.sathish.nikerundataload.loader.service.NikeRunApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nike")
@RequiredArgsConstructor
@Slf4j
class NikeActivityController {
    @Autowired
    NikeRunApiService nikeRunApiService;

    public NikeRunsDataDTO getPagedNikeActivities(@RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber) {

        NikeRunsDataDTO nikeRunsDBData = nikeRunApiService.getPaginatedNikeRunsData(pageNumber);
        return nikeRunsDBData;
    }
}
