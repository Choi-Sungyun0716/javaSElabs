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
		System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}

	public boolean removeItem(String title) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getTitle().equals(title)) {
				Publication removed = items.remove(i);
				System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
				return true; // ���������� ���ŵ� }
			}
		}

		System.out.println("�ش� ������ ���ǹ��� ã�� �� �����ϴ�.");
		return false; // ���� ����

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
			// ManageBook���� �ٸ� ������ ���� (�뵵�� ����ȭ)
			if (item instanceof Magazine) {
				total += item.getPrice() * 0.9; // 10% ����
			} else if (item instanceof Novel) {
				total += item.getPrice() * 0.85; // 15% ����
			} else if (item instanceof ReferenceBook) {
				total += item.getPrice() * 0.8; // 20% ����
			} else {
				total += item.getPrice(); // �⺻ ���ǹ��� ���� ����
			}
		}
		return total;
	}

	public void printStatistics() {
		int magazineCount = 0;
		int novelCount = 0;
		int referenceBookCount = 0; // instanceof�� Ȱ���� Ÿ�Ժ� ī����
		for (Publication item : items) {
			if (item instanceof Magazine) {
				magazineCount++;
			} else if (item instanceof Novel) {
				novelCount++;
			} else if (item instanceof ReferenceBook) {
				referenceBookCount++;
			}
		}

		System.out.println("����: " + magazineCount + "��");
		System.out.println("�Ҽ�: " + novelCount + "��");
		System.out.println("����: " + referenceBookCount + "��");
	}

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		cart.addItem(new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"));
		cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
		cart.addItem(new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
		cart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));
		cart.addItem(new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"));
		cart.addItem(new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�"));

		System.out.println("\n=== ��ٱ��� ���� ===");
		cart.displayCart();

		System.out.println("\n=== ��� ===");
		cart.printStatistics();

		System.out.println("\n=== '���߿�' ���� ===");
		cart.removeItem("���߿�");

		System.out.println("\n=== ����� ��ٱ��� ���� ===");
		cart.displayCart();

		System.out.println("\n�� ����: " + cart.calculateTotalPrice() + "��");
		System.out.println("���� ���� ����: " + cart.calculateDiscountedPrice() + "��");

	}

}
