package workshop.book.control;

import workshop.book.entity.Magazine;
import workshop.book.entity.Novel;
import workshop.book.entity.Publication;
import workshop.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {

		Publication[] pubs = new Publication[5];
		pubs[0] = new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
		pubs[1] = new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�");
		pubs[2] = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
		pubs[3] = new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�");
		pubs[4] = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");
		
		System.out.println("==== Book ���� ��� ====");
		for (Publication pub : pubs) {
			System.out.println(pub.toString()); // pub.toString()
		}
		
		System.out.println("");
		System.out.println("==== �������� ���� ��====");
		for (Publication pub : pubs) {
			System.out.println(pub.toString() + ":" + pub.getPrice()); // pub.toString()
		}
		modifyPrice(pubs);
		System.out.println("");
		System.out.println("==== �������� ���� ��====");
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
