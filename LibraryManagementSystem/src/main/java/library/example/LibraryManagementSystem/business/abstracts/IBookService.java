package library.example.LibraryManagementSystem.business.abstracts;

import library.example.LibraryManagementSystem.entity.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save (Book book);
    Page<Book> cursor (int page, int pageSize);


}
