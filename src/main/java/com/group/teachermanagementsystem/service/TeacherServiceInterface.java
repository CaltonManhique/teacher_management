package com.group.teachermanagementsystem.service;

import com.group.teachermanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherServiceInterface {

    List<Teacher> findAll();

    Teacher createTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteById(Long id);

    Teacher findTeacherById(Long id);
}
