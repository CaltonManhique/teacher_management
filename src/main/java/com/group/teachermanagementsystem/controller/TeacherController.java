package com.group.teachermanagementsystem.controller;

import com.group.teachermanagementsystem.entity.Teacher;
import com.group.teachermanagementsystem.service.TeacherServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    private TeacherServiceInterface teacherService;

    @Autowired
    public TeacherController(TeacherServiceInterface teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String showTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers";
    }

    @GetMapping("/teachers/add")
    public String showAddForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "add-teacher";
    }

    @PostMapping("/teachers/add")
    public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String showEditTeacherForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("teacher", teacherService.findTeacherById(id));
        return "edit-teacher";
    }

    @PostMapping("/teachers/edit/{id}")
    public String editTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher) {
        teacher.setId(id);
        teacherService.updateTeacher(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping( "/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }


}
