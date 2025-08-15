package assignment.book.control;

import java.io.ObjectInputStream.GetField;

import assignment.book.entity.Magazine;
import assignment.book.entity.Publication;
import assignment.book.entity.ReferenceBook;
import assignment.book.entity.Novel;

public class ManageBook {

	public static void main(String[] args) {

		Publication[] publications = { new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
				new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
				new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
				new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
				new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
				new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
				new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설") };
		
		
		System.out.println("==== 도서 정보 출력 ====");
        int index = 1;
        for (Publication publication : publications) {
            System.out.println(index + ". " + publication.toString());
            index++;
        }

		System.out.println("==== 가격 변경 ====");
		modifyPrice(publications[2]);

		System.out.println("===== 출판물 통계 분석 =====");
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		analyzer.printStatistics(publications); // 타입별 평균 가격, 분포, 2007년도 비율 출력

	}

	public static void modifyPrice(Publication publication) {
		int currentPrice = publication.getPrice();
		// instanceof로 실제 객체 타입 확인 후 차별적 할인 적용
		if (publication instanceof Magazine) {
			publication.setPrice((int) (currentPrice * 0.6)); // 40% 할인
		} else if (publication instanceof Novel) {
			publication.setPrice((int) (currentPrice * 0.8)); // 20% 할인
		} else if (publication instanceof ReferenceBook) {
			publication.setPrice((int) (currentPrice * 0.9)); // 10% 할인 }
		}

		System.out.println(publication.getTitle() + " 변경 전 가격:" + currentPrice);
		System.out.println(publication.getTitle() + " 변경 전 가격:" + publication.getPrice());

		System.out.println("차액:" + (currentPrice - publication.getPrice()));

	}

}
