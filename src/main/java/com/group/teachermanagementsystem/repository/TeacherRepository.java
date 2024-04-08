package com.group.teachermanagementsystem.repository;

import com.group.teachermanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
