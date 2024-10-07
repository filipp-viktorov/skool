package sk.viktorov.skool.homework.collections.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Library} class represents a Library which manages collections of books and authors.
 * It provides functionalities to add authors, add books to specific authors,
 * retrieve books by authors, and retrieve the complete list of books and authors in the library.
 */
public class Library {
    private Map<Author, ArrayList<Book>> authorToBooks;

    public Library() {
        this.authorToBooks = new HashMap<>();
    }

    public ArrayList<Book> getBooksOfAuthor(String authorName) {
        Author author = findAuthorByName(authorName);
        if (author != null) {
            return authorToBooks.getOrDefault(author, new ArrayList<>());
        }
        return new ArrayList<>();
    }

    public void addBookToAuthor(String authorName, Book book) {
        Author author = findAuthorByName(authorName);
        if (author != null) {
            authorToBooks.get(author).add(book);
        } else {
            System.out.println("Author not found. Add an author first.");
        }
    }

    public ArrayList<Author> getAllAuthors() {
        return new ArrayList<>(authorToBooks.keySet());
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        for (ArrayList<Book> booksList : authorToBooks.values()) {
            allBooks.addAll(booksList);
        }
        return allBooks;
    }

    public Map<Author, ArrayList<Book>> getAllBooksAndAuthors() {
        Map<Author, ArrayList<Book>> allBooksAndAuthors = new HashMap<>();
        for (Map.Entry<Author, ArrayList<Book>> entry : authorToBooks.entrySet()) {
            allBooksAndAuthors.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return allBooksAndAuthors;
    }

    public void addAuthor(Author author) {
        authorToBooks.putIfAbsent(author, new ArrayList<>());
    }

    private Author findAuthorByName(String authorName) {
        for (Author author : authorToBooks.keySet()) {
            if (author.getName().equals(authorName)) {
                return author;
            }
        }
        return null;
    }
}
