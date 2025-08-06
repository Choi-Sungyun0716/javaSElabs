package assignment.assignment1.student.control;

import assignment.assignment1.student.entity.Student;
import assignment.assignment1.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		
		try {
			Student student = new Student("20250806", "김민수", "컴퓨터공학과", 3);
			System.out.println(student.getName()+"/"+ 
							student.getMajor() + "/" +
							student.getGrade()+"학년");
			System.out.println("학년을 5학년으로 변경");
			student.setGrade(5);
	
		} catch (InvalidGradeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		

	}

}
