import java.util.*;

class Book {
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in the Library:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Category: " + book.getCategory() + ", Available: " + book.isAvailable());
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(String title) {
        Book book = findBook(title);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book " + title + " issued successfully.");
        } else if (book != null && !book.isAvailable()) {
            System.out.println("Book " + title + " is already issued.");
        } else {
            System.out.println("Book " + title + " not found.");
        }
    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book " + title + " returned successfully.");
        } else if (book != null && book.isAvailable()) {
            System.out.println("Book " + title + " is already available.");
        } else {
            System.out.println("Book " + title + " not found.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Book1", "Author1", "Category1");
        Book book2 = new Book("Book2", "Author2", "Category2");
        library.addBook(book1);
        library.addBook(book2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to issue: ");
                    scanner.nextLine(); // Consume newline character
                    String issueTitle = scanner.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to return: ");
                    scanner.nextLine(); // Consume newline character
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
