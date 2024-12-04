package org.example;

class Book {

    public String title = "";
    public String author = "";
    public int price = 0;
    public String publisher = "";
    public String isbn = "1111111111";

    Book(){}

    Book(String title){
        this.title = title;
        toTitleCase();
    }

    Book(String title, String author, int price, String publisher, String isbn){
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.isbn = isbn;
        toTitleCase();
    }

    Book(Book book){
        book.title = this.title;
        book.author = this.author;
        book.price = this.price;
        book.publisher = this.publisher;
        book.isbn = this.isbn;
        toTitleCase();
    }

    public byte checkIsbnStatus(){
        byte status = 0;
        int number = 0;
        for (int i = 0; i <= isbn.length()-1; i++){
            if (isbn.charAt(i) != '-'){
                number += 1;
            }
        }

        if (number == 13){
            status = 1;
        }

        return status;
    }

    // TURNS TITLE TO TITLECASE
    public void toTitleCase(){
        this.title = Character.toUpperCase(title.charAt(0))+title.substring(1);
        for (int i = 1; i < this.title.length(); i++){
            if (title.charAt(i)==' '){
                title = title.substring(0, i+1)+Character.toUpperCase(title.charAt(i+1))+title.substring(i+2);
            }
        }
    }

    // DISPLAYS THE INFORMATION OF THIS BOOK
    public String toString(){
        String response = "";
        response += String.format("%-14s: %-20s\n", "Title", this.title); // 14 instead of 15 because a bracket gets created upon printing
        response += String.format("%-15s: %-20s\n", "Author", this.author);
        response += String.format("%-15s: %-20s\n", "Publisher", this.publisher);
        response += String.format("%-15s: %-20s\n", "Price", this.price);
        response += String.format("%-15s: %-20s", "ISBN", this.isbn);

        return response;
    }

    // DETERMINES WHETHER THIS BOOK IS EQUAL TO ANOTHER
    public boolean equals(Book book){
        return this.title == book.title && this.author == book.author && this.price == book.price && this.publisher == book.publisher && this.isbn == book.isbn;
    }

    // CREATES CLONE OF BOOK
    public Book clone(){
        Book newBook = new Book();
        newBook.title = this.title;
        newBook.author = this.author;
        newBook.publisher = this.publisher;
        newBook.isbn = this.isbn;
        newBook.price = this.price;
        return newBook;
    }

    // GETTER METHODS
    public String getIsbn(){
        return this.isbn;
    }

    public int getPrice(){
        return this.price;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    // SETTER METHODS
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public void setTitle(String title){
        this.title = title;
    }

}
