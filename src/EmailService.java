public class EmailService {
    public void send(EBook book, int quantity, EmailInfo info) {
        System.out.println("[Quantum Bookstore] Sending " + quantity + "x " + book.getTitle() + " (" + book.getFileType() + ") to " + info.getEmail());
    }
}
