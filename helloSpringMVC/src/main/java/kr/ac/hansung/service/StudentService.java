package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.StudentDAO;
import kr.ac.hansung.model.Student;

@Service
public class StudentService {

	private StudentDAO studentDao;

	@Autowired
	public void setOfferDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
//----------------------------------------------------
//1.학기별 이수 학점 조회
	public List<Student> getCurrent() {
		return studentDao.getStudents();
	}

	// 학기별 이수 학점 조회에서 상세보기 했을때 나오는 list...
	public List<Student> getCurrent2(int year, int semester) {
		List<Student> student=studentDao.getStudents2(year, semester);
		return student;
	}

//-----------------------------------------------------
//2.이수 구분별 학점가져오기.
	public List<Student> getCount3() {
		int sum = 0;
		List<Student> student3 = studentDao.getCounts3();
		for (Student tt : student3) {
			sum += tt.getCredit();
		}
		Student creditsum = new Student();
		creditsum.setClassify("총합계");
		creditsum.setCredit(sum);

		student3.add(creditsum);
		return student3;
	}
	
//-----------------------------------------------------
	//3. 2019년도 1학기 수강 신청하는 경우 insert
	public void insert(Student student) {
		studentDao.insert(student);
	}
	
//-----------------------------------------------------
	//4. 수강 신청 조회 메뉴.
	public List<Student> getregisterstudent() {
		return studentDao.getregisterstudent();
	}

}