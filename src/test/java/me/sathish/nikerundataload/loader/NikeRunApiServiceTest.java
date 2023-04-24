package me.sathish.nikerundataload.loader;

import me.sathish.nikerundataload.loader.jpa.NikeRunsDataDTO;
import me.sathish.nikerundataload.loader.service.NikeRunApiService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NikeRunApiServiceTest {
    @Autowired
    NikeRunApiService nikeRunApiService;

    @Test
    void testSaveNikeRunApi() {
        nikeRunApiService.SaveNikeRunApi();
    }

    @Test
    void testGetPaginatedNikeRunsData() {
        NikeRunsDataDTO nikeRunsDBDataList = nikeRunApiService.getPaginatedNikeRunsData(1, 10);
        Assert.assertTrue(nikeRunsDBDataList.getData().size() <= 10);
    }
}
