package com.codeit.jpastudy.chap03.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.codeit.jpastudy.chap03.entity.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class StudentPageRepositoryTest {

    @Autowired
    StudentPageRepository studentPageRepository;

    @BeforeEach
    void setUp() {

        for (int i = 1; i <= 147; i++){
            Student student = Student.builder()
                .name("김메롱" + i)
                .city("서울시" + i)
                .major("컴퓨터공학과" + i)
                .build();
        }

    }

    @Test
    @DisplayName("기본적인 페이지 조회 테스트")
    void basicPageTest() {
        // given


        // when


        // then


    }

}