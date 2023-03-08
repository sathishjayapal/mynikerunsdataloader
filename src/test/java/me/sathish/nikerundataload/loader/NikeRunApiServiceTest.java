package me.sathish.nikerundataload.loader;

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
    void saveNikeRunApi() {
        nikeRunApiService.SaveNikeRunApi();
    }
}
