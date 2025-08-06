package assignment.assignment1.student.control;

import assignment.assignment1.student.entity.Student;
import assignment.assignment1.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		
		try {
			Student student = new Student("20250806", "��μ�", "��ǻ�Ͱ��а�", 3);
			System.out.println(student.getName()+"/"+ 
							student.getMajor() + "/" +
							student.getGrade()+"�г�");
			System.out.println("�г��� 5�г����� ����");
			student.setGrade(5);
	
		} catch (InvalidGradeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		

	}

}
