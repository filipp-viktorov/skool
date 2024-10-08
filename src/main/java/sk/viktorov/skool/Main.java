package sk.viktorov.skool;

import sk.viktorov.skool.homework.collections.Averager;
import sk.viktorov.skool.homework.collections.Calculator;
import sk.viktorov.skool.homework.collections.library.Author;
import sk.viktorov.skool.homework.collections.library.Book;
import sk.viktorov.skool.homework.collections.library.Library;

public class Main {
    public static void main(String[] args) {

        //Average number
        Averager averager = new Averager();
        System.out.println(averager.calculateAverage());

        //Calculator
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.subtract(5, 2));
        System.out.println(calculator.multiply(4, 3));
        System.out.println(calculator.divide(10, 2));
        System.out.println(calculator.divide(10, 0));
        calculator.displayOperations();
        
        //Library
        Library library = new Library();

        library.addAuthor(new Author("Stephen King", 77, "Horror"));
        library.addAuthor(new Author("Ray Bradbury", 91, "Mystery"));
        library.addAuthor(new Author("Lee Child", 69, "Detective"));

        library.addBookToAuthor("Stephen King", new Book("The Dark Tower", "Adventure", 1000));
        library.addBookToAuthor("Stephen King", new Book("It", "Horror", 400));
        library.addBookToAuthor("Stephen King", new Book("The Green Mile", "Fantasy", 200));
        library.addBookToAuthor("Lee Child", new Book("Jack Richer", "Detective", 96));
        library.addBookToAuthor("Ray Bradbury", new Book("Fahrenheit 451", "Fantasy", 451));

        System.out.println("Adding book to unknown author:");
        library.addBookToAuthor("\n" + "Fiodor Dostojevskij", new Book("The Idiot", "Satire", 69));

        System.out.println("\n" + "Get books of author Stephen King:");
        System.out.println(library.getBooksOfAuthor("Stephen King"));

        System.out.println("\n" + "Get all the authors:");
        System.out.println(library.getAllAuthors());

        System.out.println("\n" + "Get all the books:");
        System.out.println(library.getAllBooks());

        System.out.println("\n" + "Get all the books and authors:");
        System.out.println(library.getAllBooksAndAuthors());
    }
}
