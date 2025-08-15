package assignment.book.control;

import java.io.ObjectInputStream.GetField;

import assignment.book.entity.Magazine;
import assignment.book.entity.Publication;
import assignment.book.entity.ReferenceBook;
import assignment.book.entity.Novel;

public class ManageBook {

	public static void main(String[] args) {

		Publication[] publications = { new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
				new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
				new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
				new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
				new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
				new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
				new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�") };
		
		
		System.out.println("==== ���� ���� ��� ====");
        int index = 1;
        for (Publication publication : publications) {
            System.out.println(index + ". " + publication.toString());
            index++;
        }

		System.out.println("==== ���� ���� ====");
		modifyPrice(publications[2]);

		System.out.println("===== ���ǹ� ��� �м� =====");
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		analyzer.printStatistics(publications); // Ÿ�Ժ� ��� ����, ����, 2007�⵵ ���� ���

	}

	public static void modifyPrice(Publication publication) {
		int currentPrice = publication.getPrice();
		// instanceof�� ���� ��ü Ÿ�� Ȯ�� �� ������ ���� ����
		if (publication instanceof Magazine) {
			publication.setPrice((int) (currentPrice * 0.6)); // 40% ����
		} else if (publication instanceof Novel) {
			publication.setPrice((int) (currentPrice * 0.8)); // 20% ����
		} else if (publication instanceof ReferenceBook) {
			publication.setPrice((int) (currentPrice * 0.9)); // 10% ���� }
		}

		System.out.println(publication.getTitle() + " ���� �� ����:" + currentPrice);
		System.out.println(publication.getTitle() + " ���� �� ����:" + publication.getPrice());

		System.out.println("����:" + (currentPrice - publication.getPrice()));

	}

}
