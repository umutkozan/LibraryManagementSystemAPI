package library.example.LibraryManagementSystem.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    @NotNull
    private String name;
    @NotNull
    private Integer publication_year;
    @NotNull
    private Long author;
    @NotNull
    private Long  publisher;
    @NotNull
    private Integer book_stock;

}
