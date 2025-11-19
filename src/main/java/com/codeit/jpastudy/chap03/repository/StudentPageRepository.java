package com.codeit.jpastudy.chap03.repository;

import com.codeit.jpastudy.chap03.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPageRepository extends JpaRepository<Student, String> {




}
