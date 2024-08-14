package library.example.LibraryManagementSystem.dto.response.bookBorrow;

import org.antlr.v4.runtime.misc.NotNull;

public class BookBorrowResponse {
    @NotNull
    private Long id;
    @NotNull
    private String borrowerName;
    @NotNull
    private java.util.Date borrowingDate;
    @NotNull
    private java.util.Date returnDate;
    @NotNull
    private Long bookId;
}
