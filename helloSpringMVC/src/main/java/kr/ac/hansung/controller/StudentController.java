package kr.ac.hansung.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Student;
import kr.ac.hansung.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	@Autowired
	public void setOffersService(StudentService studentService) {
		this.studentService = studentService;
	}
//--------------------------------------------------
	// 1-1.학기별 이수 학점 조회
	@RequestMapping("/semestergrade")
	public String showsemesterStudents(Model model) {
		List<Student> student = studentService.getCurrent();
		model.addAttribute("student", student);
		return "semestergrade";
	}

	// 1-2.학기별 이수 학점 조회->상세보기 클릭시.
	@RequestMapping("/semestergrade2")
	public String showsemesterStudents2(Model model, Integer year, Integer semester) {
		List<Student> student2 = studentService.getCurrent2(year, semester);
		model.addAttribute("year",year);
		model.addAttribute("semester",semester);
		model.addAttribute("student2", student2);
		return "semestergrade2";
	}

// -------------------------------------------------
	// 2.이수 구분별 학점 조회
	@RequestMapping("/totalgrade")
	public String getCount(Model model) {
		List<Student> student3 = studentService.getCount3();
		model.addAttribute("student3", student3);
		return "totalgrade";
	}

// -------------------------------------------------
	// 3-1.수강 신청하기 (페이지)
	@RequestMapping("/classregister")
	public String createRegister(Model model) {
		return "classregister";
	}

	// 3-2.수강 신청하기 (등록)
	@RequestMapping("/docreate") 
	public String doCreate(Model model, Student student, BindingResult result) {
		// 에러처리 x
		studentService.insert(student);
		return "home"; // 수강 신청 조회 메뉴로 이동.
	}

// ------------------------------------------------------
	// 4.수강 신청 조회 메뉴
	@RequestMapping("/classregistermenu")
	public String showclassregistremenu(Model model) {
		List<Student> registerstudent = studentService.getregisterstudent();
		model.addAttribute("registerstudent", registerstudent);
		return "classregistermenu";
	}

}
