package library.example.LibraryManagementSystem.core.result;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Getter
public class Result {
    private boolean status;
    private String message;

    public Result(boolean status, String httpCode, String message) {
        this.status = status;
        this.httpCode = httpCode;
        this.message = message;
    }

    private String httpCode;

}