package library.example.LibraryManagementSystem.business.abstracts;

import library.example.LibraryManagementSystem.entity.BookBorrow;
import org.springframework.data.domain.Page;

public interface BookBorrowingService {
    BookBorrow save (BookBorrow bookBorrowing);
    Page<BookBorrow> cursor (int page, int pageSize);
    BookBorrow update(BookBorrow bookBorrow);
    BookBorrow get(long id);

}
