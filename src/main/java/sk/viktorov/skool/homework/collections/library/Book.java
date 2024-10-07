package sk.viktorov.skool.homework.collections.library;

import java.util.Objects;

public class Book {
    private String title;
    private String genre;
    private int numberOfPages;

    public Book(String title, String genre, int numberOfPages) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Book book = (Book) object;
        return numberOfPages == book.numberOfPages &&
                title.equals(book.title) &&
                genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, numberOfPages);
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %d pages)", title, genre, numberOfPages);
    }
}
