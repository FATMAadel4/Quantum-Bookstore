import java.util.*;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();
    private ShippingService shippingService = new ShippingService();
    private EmailService emailService = new EmailService();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("[Quantum Bookstore] Added: " + book.getTitle());
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public double buyBook(String isbn, int quantity, Object deliveryInfo) {
        Book book = getBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        if (!book.isForSale()) {
            throw new IllegalStateException("Book not for sale");
        }

        double totalPrice = book.getPrice() * quantity;

        if (book instanceof PaperBook) {
            PaperBook pb = (PaperBook) book;
            pb.reduceStock(quantity);
            shippingService.ship(pb, quantity, (ShippingInfo) deliveryInfo);
        } else if (book instanceof EBook) {
            emailService.send((EBook) book, quantity, (EmailInfo) deliveryInfo);
        } else {
            throw new IllegalArgumentException("Unsupported book type");
        }

        return totalPrice;
    }

    public List<Book> removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> outdated = new ArrayList<>();

        for (Book book : new ArrayList<>(inventory.values())) {
            if (currentYear - book.getYear() > maxAge) {
                outdated.add(book);
                inventory.remove(book.getIsbn());
            }
        }

        return outdated;
    }

    public int getInventoryCount() {
        return inventory.size();
    }
}
