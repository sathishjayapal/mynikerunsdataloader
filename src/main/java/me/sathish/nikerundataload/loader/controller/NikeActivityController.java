package me.sathish.nikerundataload.loader.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sathish.nikerundataload.loader.jpa.NikeRunsDataDTO;
import me.sathish.nikerundataload.loader.service.NikeRunApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/nike")
@RequiredArgsConstructor
@Slf4j
class NikeActivityController {
    @Autowired
    NikeRunApiService nikeRunApiService;

    @RequestMapping(value = {"", "/{pageNumber}", "/{pageNumber}/{pageSize}"})
    public NikeRunsDataDTO getPagedNikeActivities(@PathVariable(name = "pageNumber") Optional<Integer> pageNumber, @PathVariable(name = "pageSize") Optional<Integer> pageSize) {
        if (!pageNumber.isPresent())
            pageNumber = Optional.of(1);
        if (!pageSize.isPresent())
            pageSize = Optional.of(10);

        NikeRunsDataDTO nikeRunsDBData = nikeRunApiService.getPaginatedNikeRunsData(pageNumber.get(), pageSize.get());
        return nikeRunsDBData;
    }
}
