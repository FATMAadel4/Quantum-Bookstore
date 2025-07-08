public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, double price, int year, int stock) {
        super(isbn, title, author, price, year);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return stock > 0;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock for " + getTitle());
        }
        stock -= quantity;
    }
}
