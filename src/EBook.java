public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, double price, int year, String fileType) {
        super(isbn, title, author, price, year);
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    public String getFileType() {
        return fileType;
    }
}
