package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Professor;
import net.skhu.dto.Course;
import net.skhu.mapper.ProfessorMapper;
import net.skhu.mapper.CourseMapper;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    ProfessorMapper professorMapper;

    // 학생 목록 페이지로 이동
    @GetMapping("list")
    public String list(Model model) {
        List<Course> courses = courseMapper.findAll();
        model.addAttribute("courses", courses);
        return "course/list";
    }

    // 학생 생성 페이지로 이동
    @GetMapping("create")
    public String create(Model model) { 
        Course course = new Course(); // 빈 학생 객체 생성
        List<Professor> professors = professorMapper.findAll(); // 모든 학과 정보 가져오기
        model.addAttribute("course", course);
        model.addAttribute("professors", professors);
        return "course/edit"; // 학생 생성/수정 페이지 사용
    }

    // 학생 생성 처리
    @PostMapping("create")
    public String create(Model model, Course course) {
        courseMapper.insert(course);
        return "redirect:list"; // 학생 목록 페이지로 리다이렉트
    }

    // 학생 수정 페이지로 이동
    @GetMapping("edit")
    public String edit(Model model, int id) {
        Course course = courseMapper.findOne(id); // 수정할 학생 정보 가져오기
        List<Professor> professors = professorMapper.findAll(); // 모든 학과 정보 가져오기
        model.addAttribute("course", course);
        model.addAttribute("professors", professors);
        return "course/edit"; // 학생 생성/수정 페이지 사용
    }

    // 학생 수정 처리
    @PostMapping("edit")
    public String edit(Model model, Course course) {
        courseMapper.update(course);
        return "redirect:list"; // 학생 목록 페이지로 리다이렉트
    }

    // 학생 삭제 처리
    @GetMapping("delete")
    public String delete(Model model, int id) {
        courseMapper.delete(id);
        return "redirect:list"; // 학생 목록 페이지로 리다이렉트
    }
}
