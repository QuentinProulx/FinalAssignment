package org.example;

class Book {

    public String title;
    public String author;
    public int price;
    public String publisher;
    public String isbn;

    Book(){

    }

    Book(String title){

    }

    Book(String title, String author, int price, String publisher, String isbn){

    }

    Book(Book book){
        book.title = this.title;
        book.author = this.author;
        book.price = this.price;
        book.publisher = this.publisher;
        book.isbn = this.isbn;
    }

    public void toTitleCase(){
        for (int i = 1; i < this.title.length(); i++){
            if (title.charAt(i)==' '){

            }
        }
    }

}
