public abstract class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;
    private int year;

    public Book(String isbn, String title, String author, double price, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public abstract boolean isForSale();
}
