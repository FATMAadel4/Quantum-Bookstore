public class ShippingService {
    public void ship(PaperBook book, int quantity, ShippingInfo info) {
        System.out.println("[Quantum Bookstore] Shipping " + quantity + "x " + book.getTitle() + " to " + info.getAddress());
    }
}
