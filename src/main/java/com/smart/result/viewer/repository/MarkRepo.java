package com.smart.result.viewer.repository;

import com.smart.result.viewer.entity.Mark;
import com.smart.result.viewer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepo extends JpaRepository<Mark , Long>
{
    List<Mark> findByStudent(Student student);
}
