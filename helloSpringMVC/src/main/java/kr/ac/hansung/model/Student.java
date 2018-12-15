package kr.ac.hansung.model;

public class Student {
	// id , 수강년도, 학기, 교과코드 , 교과목명, 구분, 학점.

	private int id;
	private int year; // 년도
	private int semester; // 학기
	private String subjectCode; // 과목코드
	private String subjectName; // 과목명
	private String classify; // 이수 구분별 과목
	private int credit; // 학점

	public Student() {

	}

	public Student(int year, int semester, String subjectCode, String subjectName, String classify, int credit) {
		super();
		this.year = year;
		this.semester = semester;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.classify = classify;
		this.credit = credit;
	}

	public Student(int id, int year, int semester, String subjectCode, String subjectName, String classify,
			int credit) {
		super();
		this.id = id;
		this.year = year;
		this.semester = semester;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.classify = classify;
		this.credit = credit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}