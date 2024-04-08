package com.group.teachermanagementsystem.service;

import com.group.teachermanagementsystem.entity.Teacher;
import com.group.teachermanagementsystem.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Transactional
    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {

        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            teacherRepository.deleteById(id);
        } else {
            throw new RuntimeException("Teacher with id: " + id + " not found!");
        }
    }

    @Override
    public Teacher findTeacherById(Long id) {
        Teacher teacher = null;

        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            teacher = optionalTeacher.get();
        } else {
            throw new RuntimeException("Teacher with id: " + id + " not found!");
        }

        return teacher;
    }
}
