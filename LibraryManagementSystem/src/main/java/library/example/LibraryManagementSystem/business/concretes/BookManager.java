package library.example.LibraryManagementSystem.business.concretes;

import library.example.LibraryManagementSystem.business.abstracts.IBookService;
import library.example.LibraryManagementSystem.entity.Book;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements IBookService {
    private final BookRepo bookRepo;

    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    public Page<Book> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Book> bookPage = this.bookRepo.findAll(pageable);
        if (bookPage.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException("No books found");
        }
        return bookPage;
    }


}
