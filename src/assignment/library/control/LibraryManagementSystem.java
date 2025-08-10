package assignment.library.control;

import assignment.library.entity.Book;
import assignment.library.entity.Library;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);

        System.out.println("===== " + library.getName() + " =====");
        printLibraryStatus(library);

        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");
        testFindBook(library);

        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        testCheckOut(library);

        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        testReturn(library);

        System.out.println("===== ���� ������ ���� ��� =====");
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }

    private static void testFindBook(Library library) {
        Book bookByTitle = library.findByTitle("�ڹ��� ����");
        if (bookByTitle != null) {
            System.out.println("�������� �˻� ���:");
            System.out.println(bookByTitle);
        }

        List<Book> booksByAuthor = library.findByAuthor("Robert C. Martin");
        if (!booksByAuthor.isEmpty()) {
            System.out.println("\n���ڷ� �˻� ���:");
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        }
    }

    private static void testCheckOut(Library library) {
        String isbn = "978-89-01-14077-4";
        if (library.checkOutBook(isbn)) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findByISBN(isbn));
        } else {
            System.out.println("���� ���� ����!");
        }
        System.out.println("\n������ ���� ����:");
        printLibraryStatus(library);
    }

    private static void testReturn(Library library) {
        String isbn = "978-89-01-14077-4";
        if (library.returnBook(isbn)) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(library.findByISBN(isbn));
        } else {
            System.out.println("���� �ݳ� ����!");
        }
        System.out.println("\n������ ���� ����:");
        printLibraryStatus(library);
    }

    private static void displayAvailableBooks(Library library) {
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}
