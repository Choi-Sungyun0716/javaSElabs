package assignment.assignment1.student.entity;

import assignment.assignment1.student.exception.InvalidGradeException;


public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	
	
	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException{
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		setGrade(grade);
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) throws InvalidGradeException{
		
		if(grade < 1 || grade > 4) {
			String errMessage = String.format("학년은 1~4 사이여야 합니다.");
			throw new InvalidGradeException(errMessage);
		}
		
		this.grade = grade;
	}
	
	
}
