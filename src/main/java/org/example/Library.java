package org.example;

import java.util.ArrayList;

public class Library {

    public static void main(String[] args) {

        // Creating new array
        ArrayList<Book> libArr = new ArrayList<>();

        // Filling the array with books
        for (int i = 0; i < 7; i++) {
            libArr.add(new Book("this book is titlecase"+i, "Johnathan Book"+i, 15+i, "Book club"+i, "1111111111"));
        }

        // Creating library
        Library lib = new Library(libArr);

        // Testing library methods (toString() and searchBook()) and book methods (toString())
        System.out.println("lib.toString(): "+lib.toString());
        System.out.println("lib.searchBook(\"6\").toString(): "+lib.searchBook("6").toString());

        // Creating clone of Library lib
        Library clone = new Library(lib);
        System.out.println("Creating clone...");

        // Checking the Library.equals() method (should return true)
        System.out.println("Clone is equal to original: "+lib.equals(clone));

        // Change the clone's isbn to an isbn-13 instead of an isbn-10
        clone.books.get(0).isbn = "123-222-3-2112-3-1";
        System.out.println("Changing clone's isbn...");

        // Checking the Library.equals() method (should return false)
        System.out.println(lib.equals(clone));

    }

    ArrayList<Book> books = new ArrayList<Book>();

    Library() {
        for (int i = 0; i <= 5; i++) {
            books.add(new Book());
        }
    }

    Library(ArrayList<Book> books) {
        this.books = books;
    }

    Library(Library library) {
        for (int i = 0; i < library.books.size(); i++) {
            this.books.add(library.books.get(i).clone());
        }
    }

    public ArrayList searchBook(String keyword){

        ArrayList<Book> list = new ArrayList<>();

        for (int i = 0; i <= books.size()-1; i++) {
            if (books.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                list.add(books.get(i));
            }
        }

        return list;
    }

    public boolean equals(Library library) {
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).equals(library.books.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String output = "{";

        for (int i = 0; i <= books.size()-1; i++) {
            output += books.get(i).title;
            if (i != books.size()-1) {
                output += ", ";
            } else {
                output += "}";
            }
        }

        return output;
    }

    // Getter Methods
    public ArrayList getBooks(){
        return books;
    }

    // Setter Methods
    public void setBooks(ArrayList<Book> books){
        this.books = books;
    }

}
