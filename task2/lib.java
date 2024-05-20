package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class lib {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
Book book1=new Book("To Kill a Mockingbird", "Harper Lee");
Book book2=new Book("1984", "George Orwell");
Book book3=new Book("The Great Gatsby", "F. Scott Fitzgerald");

        // Adding books
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        // Searching for books by title
        System.out.println("Search by title '1984': " + catalog.searchByTitle("1984"));

        // Searching for books by author
        System.out.println("Search by author 'George Orwell': " + catalog.searchByAuthor("George Orwell"));

        // Checking out a book
        catalog.checkOutBook("1984");

        // Trying to check out a book that is already checked out
        catalog.checkOutBook("1984");

        // Returning a book
        catalog.returnBook("1984");

        // Trying to return a book that is already available
        catalog.returnBook("1984");
    }
}
class Book {
    String title;
    String author;
    boolean isAvailable;

   public Book(String title, String author) {
       this.title = title;
       this.author = author;
       this.isAvailable = true;
   }

   public String getTitle() {
       return title;
   }

   public String getAuthor() {
       return author;
   }

   public boolean isAvailable() {
       return isAvailable;
   }

   public void checkOut() {
       this.isAvailable = false;
   }

   public void returnBook() {
       this.isAvailable = true;
   }

   @Override
   public String toString() {
       return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", isAvailable=" + isAvailable +
               '}';
   }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Book book = (Book) o;
       return title.equals(book.title) && author.equals(book.author);
   }

   @Override
   public int hashCode() {
       return Objects.hash(title, author);
   }  
}
 class LibraryCatalog{
  public List<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            System.out.println("Book added: " + book);
        } else {
            System.out.println("Book already exists in the catalog.");
        }
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.checkOut();
                System.out.println("Book checked out: " + book);
                return;
            }
        }
        System.out.println("Book not found or already checked out.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.returnBook();
                System.out.println("Book returned: " + book);
                return;
            }
        }
        System.out.println("Book not found or already available.");
    }   
}


