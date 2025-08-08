package workshop.person.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManagerCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonManagerCollection personMgr = new PersonManagerCollection();
		
		System.out.print("성별을 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.next();
		char gender = inputValue.charAt(0);
		System.out.print("이름을 입력하세요 : ");
		String name = scanner.next();
		
		
		System.out.println(String.format("성별은 %s, 이름은 %s", gender, name) + "\n");
		
		// 배열선언 및 초기화
		//PersonEntity[] persons = new PersonEntity[10];
		//List 사용
		List<PersonEntity> personList = new ArrayList<PersonEntity>();
		
		// persons 변수는 PersonEntity[] 타입이고, persons[0]은 PersonEntity 타입이다.
		personMgr.fillPersons(personList);
		
		
		personMgr.printTitle("인물정보 조회시스템");
		personMgr.showPerson(personList);
		
		
		
		String message = String.format("성별 : %s 은(는) %d명입니다.", gender,
										personMgr.findByGender(personList, gender) );
		System.out.println(message);
		personMgr.showPerson(personList, name);
		
		scanner.close();
		
	}
	
	
	public void showPerson(List<PersonEntity> persons, String name) {
		for(PersonEntity person: persons) {
			if(person.getName().equals(name)) {
				System.out.println("이름 :" + name + "으(로) 찾기 결과입니다.");
				System.out.println("[이름]" + person.getName() + "\n" +
						   "[성별]" + person.getGender()+ "\n" +
						   "[전화번호]" + person.getPhone()+ "\n" +
						   "[주소]" + person.getAddress());
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
			System.out.println("[이름]" + person.getName() + "\t" +
							   "[성별]" + person.getGender()+ "\t" +
							   "[전화번호]" + person.getPhone());
		}
	}

	public static void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("이성호", "7212121028102", "인천 계양구", "032-392-2932"));
		persons.add(new PersonEntity("김하늘", "7302132363217", "서울 강동구", "02-362-1932"));
		persons.add(new PersonEntity("박영수", "7503111233201", "서울 성북구", "02-887-1542"));
		persons.add(new PersonEntity("나인수", "7312041038988", "대전 유성구", "032-384-2223"));
		persons.add(new PersonEntity("홍정수", "7606221021341", "서울 양천구", "02-158-7333"));
		persons.add(new PersonEntity("이미숙", "7502142021321", "서울 강서구", "02-323-1934"));
		persons.add(new PersonEntity("박성구", "7402061023101", "서울 종로구", "02-308-0932"));
		persons.add(new PersonEntity("유성미", "7103282025101", "서울 은평구", "02-452-0939"));
		persons.add(new PersonEntity("황재현", "7806231031101", "인천 중구", "032-327-2202"));
		persons.add(new PersonEntity("최철수", "7601211025101", "인천 계양구", "032-122-7832"));
	}

	public void printTitle(String title) {
		System.out.println("@@@@ " + title + " @@@@");
	}

}
