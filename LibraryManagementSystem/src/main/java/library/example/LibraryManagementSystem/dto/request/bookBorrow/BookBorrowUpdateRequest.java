package library.example.LibraryManagementSystem.dto.request.bookBorrow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowUpdateRequest {
    @NotNull
    private String borrowerName;
    @NotNull
    private java.util.Date borrowingDate;
    @NotNull
    private java.util.Date returnDate;
    @NotNull
    private Long bookId;
}
