# Quantum Bookstore

This is my solution for **Fawry N² Dev Slope #10 - Quantum Bookstore Challenge**.  

A simple Java console app that simulates an online bookstore with different book types and purchase workflows.  

## Features
- Add books to inventory with ISBN, title, author, year, and price
- Support for different book types:
  - **PaperBook** (has stock, can be shipped)
  - **EBook** (has file type, delivered via email)
  - **ShowcaseBook** (not for sale)
- Remove outdated books older than X years
- Buy books by ISBN with quantity, email/address
  - Reduces stock
  - Checks availability
  - Returns total paid
  - Integrates with ShippingService / EmailService


##  How It Works
- Books are added to the store inventory.
- When purchasing:
  - Validates book exists and is for sale.
  - Reduces stock for PaperBooks.
  - Calls delivery service (shipping/email).
  - Calculates and returns payment total.
- Outdated books can be removed by specifying max age.



## Example Usage

Add books to inventory:
```java
store.addBook(new PaperBook("978-0134494166", "Clean Architecture", "Robert Martin", 80.0, 2017, 10));
store.addBook(new EBook("978-0132350884", "Clean Code", "Robert Martin", 25.0, 2008, "PDF"));
store.addBook(new ShowcaseBook("978-1234567890", "Upcoming Novel", "Author Unknown", 2024));


 ## Buy books:

store.purchaseBook("978-0134494166", 2, new ShippingInfo("123 Main Street"));
store.purchaseBook("978-0132350884", 1, new EmailInfo("customer@example.com"));

## Remove outdated books:
 store.removeOutdatedBooks(10);

## Sample Console Output
[Quantum Bookstore] Added: Clean Architecture
[Quantum Bookstore] Added: Clean Code
[Quantum Bookstore] Added: Upcoming Novel
[Quantum Bookstore] Inventory count: 3
[Quantum Bookstore] Shipping 2x Clean Architecture to 123 Main Street
[Quantum Bookstore] Purchase successful. Paid: $160.0
[Quantum Bookstore] Sending 1x Clean Code (PDF) to customer@example.com
[Quantum Bookstore] Purchase successful. Paid: $25.0
[Quantum Bookstore] Expected error: Book not for sale
[Quantum Bookstore] Removed outdated books: 1
[Quantum Bookstore] Inventory count: 2

 
