package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource; //interface

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Student;

@Repository
public class StudentDAO {

	private JdbcTemplate jdbcTemplateObject; 

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

//-----------------------------------------------------------------------
//1.학기별 이수 학점 조회
	public List<Student> getStudents() {
		String sqlStatement = "select year,semester,sum(credit) from school where not year=2017 group by year,semester";
		List<Student> student=jdbcTemplateObject.query(sqlStatement,new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student student=new Student();
				student.setYear(rs.getInt("year"));
				student.setSemester(rs.getInt("semester"));
				student.setCredit(rs.getInt("sum(credit)"));
				return student;
			}
		} );
		return student;
	}
	
//1-2. 상세보기
	public List<Student> getStudents2(int year,int semester) {
		String sqlStatement = "select * from school where year=? and semester=? ";
		List<Student> student = jdbcTemplateObject.query(sqlStatement, new Object[]{year, semester}, new StudentMapper());	
		return student;
	}
//--------------------------------------------------------------------------
//2.이수 구분별 학점 조회
	public  List<Student> getCounts3(){
		String sqlStatement = "select classify,sum(credit) from school where not year=2017 group by classify";
		List<Student> student=jdbcTemplateObject.query(sqlStatement,new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Student studentcount=new Student();
				studentcount.setClassify(rs.getString("classify"));
				studentcount.setCredit(rs.getInt("sum(credit)"));
				return studentcount;
			}
		} );
		return student;
	}
	
//--------------------------------------------------------------------------
// 3. 수강 신청하기
	// Insert Method
	public boolean insert(Student student) {
		int year = 2019; 
		int semester = 1; 
		String subjectcode = student.getSubjectCode();
		String subjectname = student.getSubjectName();
		String classify = student.getClassify();
		int credit = student.getCredit();
		
		String sqlStatement = "insert into school (year, semester, subjectcode, subjectname, classify, credit) values (?,?,?,?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, subjectcode, subjectname, classify, credit}) == 1);
	}

	public boolean update(Student student) {
		int year =2019; 
		int semester = 1; 
		String subjectcode = student.getSubjectCode();
		String subjectname = student.getSubjectName();
		String classify = student.getClassify();
		int credit = student.getCredit();
		int id=student.getId();

		String sqlStatement = "update school set year=?,semester=?, subjectcode=?, subjectname=?, classify=?,credit=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, subjectcode, subjectname, classify, credit,id }) == 1);
	}

// ----------------------------------------------------------------------------------
//4.수강 신청 조회 메뉴
	// multiple Object-> student list 보여주기.
		public List<Student> getregisterstudent() {
			String sqlStatement = "select * from school where year=2017";
			// 2017년 DB만 보여주기.
			return jdbcTemplateObject.query(sqlStatement, new StudentMapper());
		}

}
