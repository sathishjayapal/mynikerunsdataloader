package me.sathish.nikerundataload.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class NikeRunsStorageUtilTest {
    @Autowired
    NikeRunsStorageUtil nikeRunsStorageUtil;

    @BeforeAll
    public static void beforeClass() {
        // This method will be executed once on initialization time
    }

    @AfterAll
    public static void afterClass() {
        // This method will be executed once when all test are executed
    }

    @BeforeEach
    public void before() {

    }

    @AfterEach
    public void after() {
        // This method will be executed once after each test execution
    }


    @Test
    void makeResume() {
        nikeRunsStorageUtil.listDocuments(null);
        Assertions.assertTrue(1 == 1);
    }
}
