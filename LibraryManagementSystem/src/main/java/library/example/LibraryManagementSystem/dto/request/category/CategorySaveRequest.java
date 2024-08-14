package library.example.LibraryManagementSystem.dto.request.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySaveRequest {

    @NotNull(message = "Book ID must have value")
    private List<Long> bookId;
    @NotNull(message = "Category name must have value")
    private String categoryName;
    @NotNull(message = "Description must have value")
    private String categoryDescription;

}
