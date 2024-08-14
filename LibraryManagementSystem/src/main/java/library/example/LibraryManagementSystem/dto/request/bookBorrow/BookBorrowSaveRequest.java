package library.example.LibraryManagementSystem.dto.request.bookBorrow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowSaveRequest {
    @NotNull
    private String borrowerName;
    @NotNull
    private java.util.Date borrowingDate;
    @NotNull
    private Long bookId;
}
