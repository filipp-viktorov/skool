package sk.viktorov.skool.homework.collections.library;

import java.util.Objects;

public class Author {
    private String name;
    private int age;
    private String favouriteGenre;

    public Author(String name, int age, String favouriteGenre) {
        this.name = name;
        this.age = age;
        this.favouriteGenre = favouriteGenre;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Author author = (Author) object;
        return age == author.age &&
                name.equals(author.name) &&
                favouriteGenre.equals(author.favouriteGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, favouriteGenre);
    }


    @Override
    public String toString() {
        return String.format("%s (%d, %s)", name, age, favouriteGenre);
    }
}
