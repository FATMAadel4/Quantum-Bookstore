public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, 0, year);
    }

    @Override
    public boolean isForSale() {
        return false;
    }
}
