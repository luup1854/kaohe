package com.example.assessmentitems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.assessmentitems.service.RandomSet.randomCommon;


@SpringBootTest
class AssessmentItemsApplicationTests {
    @Test
    void contextLoads() {
        int[] result = randomCommon(1, 50, 50);
            System.out.println();


    }

}
