package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {

		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		pubs[1] = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		pubs[2] = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		pubs[3] = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		pubs[4] = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");
		
		System.out.println("==== Book 정보 출력 ====");
		for (Publication pub : pubs) {
			System.out.println(pub.toString()); // pub.toString()
		}
		
		System.out.println("");
		System.out.println("==== 가격정보 변경 전====");
		for (Publication pub : pubs) {
			System.out.println(pub.toString() + ":" + pub.getPrice()); // pub.toString()
		}
		modifyPrice(pubs);
		System.out.println("");
		System.out.println("==== 가격정보 변경 후====");
		for (Publication pub : pubs) {
			System.out.println(pub.toString() + ":" + pub.getPrice()); // pub.toString()
		}

	}

	// Polymorphic Argument
	public static void modifyPrice(Publication[] pubs) {
		for (Publication pub : pubs) {
			if (pub instanceof Magazine) {
				pub.setPrice(pub.getPrice() / 10 * 6);
			} else if (pub instanceof Novel) {
				pub.setPrice(pub.getPrice() / 10 * 8);
			} else if (pub instanceof ReferenceBook) {
				pub.setPrice(pub.getPrice() / 10 * 9);
			}
		}
	}

}
