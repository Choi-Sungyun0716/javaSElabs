package assignment.book.control;

import java.util.ArrayList;
import java.util.List;

import assignment.book.entity.Magazine;
import assignment.book.entity.Novel;
import assignment.book.entity.Publication;
import assignment.book.entity.ReferenceBook;

public class ShoppingCart {

	private List<Publication> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Publication item) {
		items.add(item);
		System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}

	public boolean removeItem(String title) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				Publication removed = items.remove(i);
				System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
				return true; // 성공적으로 제거됨 }
			}
		}

		System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
		return false; // 제거 실패

	}

	public void displayCart() {
		for (Publication publication : items) {
			System.out.println(publication.toString());
		}
	}

	public int calculateTotalPrice() {
		int total = 0;
		for (Publication publication : items) {
			total += publication.getPrice();
		}
		return total;

	}

	public int calculateDiscountedPrice() {
		int total = 0;
		for (Publication item : items) {
			// ManageBook과는 다른 할인율 적용 (용도별 차별화)
			if (item instanceof Magazine) {
				total += item.getPrice() * 0.9; // 10% 할인
			} else if (item instanceof Novel) {
				total += item.getPrice() * 0.85; // 15% 할인
			} else if (item instanceof ReferenceBook) {
				total += item.getPrice() * 0.8; // 20% 할인
			} else {
				total += item.getPrice(); // 기본 출판물은 할인 없음
			}
		}
		return total;
	}

	public void printStatistics() {
		int magazineCount = 0;
		int novelCount = 0;
		int referenceBookCount = 0; // instanceof를 활용한 타입별 카운팅
		for (Publication item : items) {
			if (item instanceof Magazine) {
				magazineCount++;
			} else if (item instanceof Novel) {
				novelCount++;
			} else if (item instanceof ReferenceBook) {
				referenceBookCount++;
			}
		}

		System.out.println("잡지: " + magazineCount + "권");
		System.out.println("소설: " + novelCount + "권");
		System.out.println("참고서: " + referenceBookCount + "권");
	}

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
		cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
		cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
		cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));
		cart.addItem(new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"));
		cart.addItem(new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설"));

		System.out.println("\n=== 장바구니 내용 ===");
		cart.displayCart();

		System.out.println("\n=== 통계 ===");
		cart.printStatistics();

		System.out.println("\n=== '빠삐용' 제거 ===");
		cart.removeItem("빠삐용");

		System.out.println("\n=== 변경된 장바구니 내용 ===");
		cart.displayCart();

		System.out.println("\n총 가격: " + cart.calculateTotalPrice() + "원");
		System.out.println("할인 적용 가격: " + cart.calculateDiscountedPrice() + "원");

	}

}
