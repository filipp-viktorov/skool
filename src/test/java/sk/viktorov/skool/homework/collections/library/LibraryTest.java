package sk.viktorov.skool.homework.collections.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
        initializeAuthors();
        initializeBooks();
    }

    private void initializeAuthors() {
        library.addAuthor(new Author("Stephen King", 77, "Horror"));
        library.addAuthor(new Author("Ray Bradbury", 91, "Mystery"));
        library.addAuthor(new Author("Lee Child", 69, "Detective"));
    }

    private void initializeBooks() {
        addBooksToAuthor("Stephen King",
                new Book("The Dark Tower", "Adventure", 1000),
                new Book("It", "Horror", 400),
                new Book("The Green Mile", "Fantasy", 200));
        addBooksToAuthor("Lee Child",
                new Book("Jack Richer", "Detective", 96));
        addBooksToAuthor("Ray Bradbury",
                new Book("Fahrenheit 451", "Fantasy", 451));
    }

    private void addBooksToAuthor(String authorName, Book... books) {
        for (Book book : books) {
            library.addBookToAuthor(authorName, book);
        }
    }

    @Test
    public void should_ReturnBooks_When_AuthorExists() {
        ArrayList<Book> expectedBooks = createBooks(
                new Book("The Dark Tower", "Adventure", 1000),
                new Book("It", "Horror", 400),
                new Book("The Green Mile", "Fantasy", 200));

        ArrayList<Book> actualBooks = library.getBooksOfAuthor("Stephen King");

        assertArrayEquals(expectedBooks.toArray(), actualBooks.toArray());
    }

    @Test
    public void should_ReturnEmptyList_When_AuthorDoesNotExist() {
        ArrayList<Book> expectedBooks = new ArrayList<>();

        ArrayList<Book> actualBooks = library.getBooksOfAuthor("Non-existing author");

        assertBooks(expectedBooks, actualBooks);
    }

    @Test
    public void should_ReturnEmptyList_When_AuthorHasNoBooks() {
        ArrayList<Book> expectedBooks = new ArrayList<>();

        ArrayList<Book> actualBooks = library.getBooksOfAuthor("Jane Austen");

        assertBooks(expectedBooks, actualBooks);
    }

    @Test
    public void should_AddBook_When_AuthorExists() {
        Book expectedBook = new Book("The Stand", "Horror", 1300);
        library.addBookToAuthor("Stephen King", expectedBook);

        ArrayList<Book> actualBooks = library.getBooksOfAuthor("Stephen King");

        assertTrue(actualBooks.contains(expectedBook));
    }

    @Test
    public void should_NotAddBook_When_AuthorDoesNotExist() {
        Book expectedBook = new Book("War and Peace", "Historical", 1300);
        library.addBookToAuthor("Leo Tolstoy", expectedBook);

        assertTrue(library.getBooksOfAuthor("Leo Tolstoy").isEmpty());
    }

    @Test
    public void should_ReturnAllAuthors_When_Requested() {
        ArrayList<Author> actualAuthors = library.getAllAuthors();
        ArrayList<Author> expectedAuthors = createAuthors(
                new Author("Stephen King", 77, "Horror"),
                new Author("Lee Child", 69, "Detective"),
                new Author("Ray Bradbury", 91, "Mystery"));

        assertArrayEquals(expectedAuthors.toArray(), actualAuthors.toArray());
    }

    @Test
    public void should_ReturnAllBooks_When_Requested() {
        ArrayList<Book> expectedBooks = createBooks(
                new Book("The Dark Tower", "Adventure", 1000),
                new Book("It", "Horror", 400),
                new Book("The Green Mile", "Fantasy", 200),
                new Book("Jack Richer", "Detective", 96),
                new Book("Fahrenheit 451", "Fantasy", 451));

        ArrayList<Book> actualBooks = library.getAllBooks();

        assertBooks(expectedBooks, actualBooks);
    }

    @Test
    public void should_ReturnAllBooksAndAuthors_When_Requested() {
        Map<Author, ArrayList<Book>> expectedBooksAndAuthors = new HashMap<>();
        expectedBooksAndAuthors.put(new Author("Stephen King", 77, "Horror"), createBooks(
                new Book("The Dark Tower", "Adventure", 1000),
                new Book("It", "Horror", 400),
                new Book("The Green Mile", "Fantasy", 200)));

        expectedBooksAndAuthors.put(new Author("Lee Child", 69, "Detective"), createBooks(
                new Book("Jack Richer", "Detective", 96)));

        expectedBooksAndAuthors.put(new Author("Ray Bradbury", 91, "Mystery"), createBooks(
                new Book("Fahrenheit 451", "Fantasy", 451)));

        Map<Author, ArrayList<Book>> actualBooksAndAuthors = library.getAllBooksAndAuthors();

        assertEquals(expectedBooksAndAuthors, actualBooksAndAuthors);
    }

    private ArrayList<Book> createBooks(Book... books) {
        return new ArrayList<>(Arrays.asList(books));
    }

    private ArrayList<Author> createAuthors(Author... authors) {
        return new ArrayList<>(Arrays.asList(authors));
    }

    private void assertBooks(ArrayList<Book> expectedBooks, ArrayList<Book> actualBooks) {
        assertArrayEquals(expectedBooks.toArray(), actualBooks.toArray());
    }
}
