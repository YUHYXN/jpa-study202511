package com.codeit.jpastudy.chap03.repository;

import com.codeit.jpastudy.chap03.entity.Student;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, UUID> {   // UUID를 PK 타입으로 지정했기 때문에.

    // JPA 쿼리 메서드 -> 메서드 이름으로 JPA가 쿼리를 만듭니다.
    // pk 관련 메서드는 기본으로 제공되지만, 다른 컬럼을 이용한 sql은 직접 생성해야합니다.
    // 메서드 이름으로 쿼리를 조합하게 작성합니다. (규칙있음)
    List<Student> findByName(String name);

    List<Student> findByCityAndMajor(String city, String major);

    // WHERE major LIkE '%major%'
    List<Student> findByByMajorContaining(String major);

    // WHERE major LIkE '%major%'
    List<Student> findByByMajorStartingWith(String major);

    // WHERE major LIkE '%major%'
    List<Student> findByByMajorEndigWith(String major);

    // WHERE age >= ?
//    findByAgeGreaterAndEuqals(int age);
    // lessAndEquals ->    age <= ?

}
