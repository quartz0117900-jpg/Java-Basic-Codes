// Book.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Book implements Comparable<Book> {

    private int bookId;
    private String title;
    private String author;
    private String publisher;

    // Constructor
    public Book(int bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // Getters
    public int getBookId()       { return bookId; }
    public String getTitle()     { return title; }
    public String getAuthor()    { return author; }
    public String getPublisher() { return publisher; }

    // Comparable - default sorting by Book ID
    @Override
    public int compareTo(Book other) {
        return this.bookId - other.bookId;
    }

    // Display
    @Override
    public String toString() {
        return "ID: " + bookId + " | Title: " + title + " | Author: " + author + " | Publisher: " + publisher;
    }
}

// Comparator - sort by Title
class SortByTitle implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }
}

// Comparator - sort by Author
class SortByAuthor implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}

public class BookSort {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(3, "Java Programming", "James Gosling",  "Oracle Press"));
        books.add(new Book(1, "Clean Code",        "Robert Martin",  "Prentice Hall"));
        books.add(new Book(4, "Data Structures",   "Mark Weiss",     "Pearson"));
        books.add(new Book(2, "Design Patterns",   "Gang of Four",   "Addison Wesley"));

        // Comparable - sort by Book ID (default)
        Collections.sort(books);
        System.out.println("--- Sorted by Book ID (Comparable) ---");
        for (Book b : books) System.out.println(b);

        // Comparator - sort by Title
        Collections.sort(books, new SortByTitle());
        System.out.println("\n--- Sorted by Title (Comparator) ---");
        for (Book b : books) System.out.println(b);

        // Comparator - sort by Author
        Collections.sort(books, new SortByAuthor());
        System.out.println("\n--- Sorted by Author (Comparator) ---");
        for (Book b : books) System.out.println(b);
    }
}