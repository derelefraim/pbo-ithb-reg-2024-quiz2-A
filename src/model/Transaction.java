package model;

public class Transaction {
    int trans_id;
    User user_id;
    Book book_id;
    public Transaction(int trans_id, User user_id, Book book_id) {
        this.trans_id = trans_id;
        this.user_id = user_id;
        this.book_id = book_id;
    }
    public Book getBook_id() {
        return book_id;
    }
    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }
}
