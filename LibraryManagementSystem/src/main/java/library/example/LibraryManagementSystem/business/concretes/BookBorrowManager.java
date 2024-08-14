package library.example.LibraryManagementSystem.business.concretes;

import library.example.LibraryManagementSystem.business.abstracts.BookBorrowingService;
import library.example.LibraryManagementSystem.entity.BookBorrow;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowManager implements BookBorrowingService {
    private final BookBorrowingRepo bookBorrowingRepo;

    public BookBorrowManager(BookBorrowingRepo bookBorrowingRepo) {
        this.bookBorrowingRepo = bookBorrowingRepo;
    }


    @Override
    public BookBorrow save(BookBorrow bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public Page<BookBorrow> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<BookBorrow> bookBorrowings = this.bookBorrowingRepo.findAll(pageable);
        if (bookBorrowings.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException("No book is borrowed.");
        }
        return bookBorrowings;
    }
    @Override
    public BookBorrow update(BookBorrow bookBorrow) {
        if(!bookBorrowingRepo.existsById(Math.toIntExact(bookBorrow.getId()))) {
            throw new ChangeSetPersister.NotFoundException("Book borrowing with book ID " + bookBorrow.getId() + " does not exist");
        }
        this.get(bookBorrow.getId());
        return this.bookBorrowingRepo.save(bookBorrow);
    }

    @Override
    public BookBorrow get(long id) {
        return this.bookBorrowingRepo.findById((int)id).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Borrowing for book " + id + " does not exist"));
    }
}