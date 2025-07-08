public class Main {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        // Add books
        store.addBook(new PaperBook("978-0000000001", "Clean Architecture", "Robert C. Martin", 40.0, 2017, 5));
        store.addBook(new EBook("978-0000000002", "Clean Code", "Robert C. Martin", 25.0, 2008, "PDF"));
        store.addBook(new ShowcaseBook("978-0000000003", "Upcoming Novel", "Author X", 2024));

        System.out.println("[Quantum Bookstore] Inventory count: " + store.getInventoryCount());

        // Buy PaperBook
        try {
            double price = store.buyBook("978-0000000001", 2, new ShippingInfo("123 Main Street"));
            System.out.println("[Quantum Bookstore] Purchase successful. Paid: $" + price);
        } catch (Exception e) {
            System.err.println("[Quantum Bookstore] Error: " + e.getMessage());
        }

        // Buy EBook
        try {
            double price = store.buyBook("978-0000000002", 1, new EmailInfo("customer@example.com"));
            System.out.println("[Quantum Bookstore] Purchase successful. Paid: $" + price);
        } catch (Exception e) {
            System.err.println("[Quantum Bookstore] Error: " + e.getMessage());
        }

        // Try buying ShowcaseBook (should fail)
        try {
            store.buyBook("978-0000000003", 1, new ShippingInfo("123 Main Street"));
        } catch (Exception e) {
            System.err.println("[Quantum Bookstore] Expected error: " + e.getMessage());
        }

        // Remove outdated
        var removed = store.removeOutdatedBooks(10);
        System.out.println("[Quantum Bookstore] Removed outdated books: " + removed.size());
        System.out.println("[Quantum Bookstore] Inventory count: " + store.getInventoryCount());
    }
}
