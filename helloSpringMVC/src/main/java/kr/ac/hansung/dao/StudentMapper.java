package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Student;

public class StudentMapper implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			// TODO Auto-generated method stub
			
			Student student=new Student();

			student.setYear(rs.getInt("year"));
			student.setSemester(rs.getInt("semester"));
			student.setSubjectCode(rs.getString("subjectcode"));
			student.setSubjectName(rs.getString("subjectname"));
			student.setClassify(rs.getString("classify"));
			student.setCredit(rs.getInt("credit"));			
			
			return student;
	}
	

}