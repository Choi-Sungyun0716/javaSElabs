package assignment.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // ���� �߰�
    public void addBook(Book book) {
        books.add(book);
        System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
    }

    // �������� ���� �˻�
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // ���ڷ� ���� �˻�
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // ISBN���� ���� �˻�
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // ���� ����
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && book.checkOut()) {
            return true;
        }
        return false;
    }

    // ���� �ݳ�
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // ���� ������ ���� ���
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // ��ü ���� ���
    public List<Book> getAllBooks() {
        return books;
    }

    // ���� �� ���� �޼���
    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    public String getName() {
        return name;
    }
}