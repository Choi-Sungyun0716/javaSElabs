package workshop.person.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManagerCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonManagerCollection personMgr = new PersonManagerCollection();
		
		System.out.print("������ �Է��ϼ��� : ");
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.next();
		char gender = inputValue.charAt(0);
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = scanner.next();
		
		
		System.out.println(String.format("������ %s, �̸��� %s", gender, name) + "\n");
		
		// �迭���� �� �ʱ�ȭ
		//PersonEntity[] persons = new PersonEntity[10];
		//List ���
		List<PersonEntity> personList = new ArrayList<PersonEntity>();
		
		// persons ������ PersonEntity[] Ÿ���̰�, persons[0]�� PersonEntity Ÿ���̴�.
		personMgr.fillPersons(personList);
		
		
		personMgr.printTitle("�ι����� ��ȸ�ý���");
		personMgr.showPerson(personList);
		
		
		
		String message = String.format("���� : %s ��(��) %d���Դϴ�.", gender,
										personMgr.findByGender(personList, gender) );
		System.out.println(message);
		personMgr.showPerson(personList, name);
		
		scanner.close();
		
	}
	
	
	public void showPerson(List<PersonEntity> persons, String name) {
		for(PersonEntity person: persons) {
			if(person.getName().equals(name)) {
				System.out.println("�̸� :" + name + "��(��) ã�� ����Դϴ�.");
				System.out.println("[�̸�]" + person.getName() + "\n" +
						   "[����]" + person.getGender()+ "\n" +
						   "[��ȭ��ȣ]" + person.getPhone()+ "\n" +
						   "[�ּ�]" + person.getAddress());
				return;
			}
		
				
		}
	}
	
	public int findByGender(List<PersonEntity> persons, char gender ) {
		int genderCnt = 0;
		for(PersonEntity person : persons) {
			if(person.getGender() == gender) {
				genderCnt++;
			}
		}
		return genderCnt;
	}
	
	

	public static void showPerson(List<PersonEntity> persons) {
		for(PersonEntity person: persons) {
			System.out.println("[�̸�]" + person.getName() + "\t" +
							   "[����]" + person.getGender()+ "\t" +
							   "[��ȭ��ȣ]" + person.getPhone());
		}
	}

	public static void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("�̼�ȣ", "7212121028102", "��õ ��籸", "032-392-2932"));
		persons.add(new PersonEntity("���ϴ�", "7302132363217", "���� ������", "02-362-1932"));
		persons.add(new PersonEntity("�ڿ���", "7503111233201", "���� ���ϱ�", "02-887-1542"));
		persons.add(new PersonEntity("���μ�", "7312041038988", "���� ������", "032-384-2223"));
		persons.add(new PersonEntity("ȫ����", "7606221021341", "���� ��õ��", "02-158-7333"));
		persons.add(new PersonEntity("�̹̼�", "7502142021321", "���� ������", "02-323-1934"));
		persons.add(new PersonEntity("�ڼ���", "7402061023101", "���� ���α�", "02-308-0932"));
		persons.add(new PersonEntity("������", "7103282025101", "���� ����", "02-452-0939"));
		persons.add(new PersonEntity("Ȳ����", "7806231031101", "��õ �߱�", "032-327-2202"));
		persons.add(new PersonEntity("��ö��", "7601211025101", "��õ ��籸", "032-122-7832"));
	}

	public void printTitle(String title) {
		System.out.println("@@@@ " + title + " @@@@");
	}

}
