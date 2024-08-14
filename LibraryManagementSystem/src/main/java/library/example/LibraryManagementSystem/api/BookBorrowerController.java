package library.example.LibraryManagementSystem.api;

import library.example.LibraryManagementSystem.business.abstracts.BookBorrowingService;
import library.example.LibraryManagementSystem.core.config.modelMapper.IModelMapper;
import library.example.LibraryManagementSystem.core.result.ResultData;
import library.example.LibraryManagementSystem.core.result.ResultHelper;
import library.example.LibraryManagementSystem.dto.request.bookBorrow.BookBorrowSaveRequest;
import library.example.LibraryManagementSystem.dto.request.bookBorrow.BookBorrowUpdateRequest;
import library.example.LibraryManagementSystem.dto.response.bookBorrow.BookBorrowResponse;
import library.example.LibraryManagementSystem.entity.BookBorrow;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookBorrowings")
public class BookBorrowerController {
    private final BookBorrowingService bookBorrowingService;
    private final IModelMapper iModelMapper;

    public BookBorrowerController(BookBorrowingService bookBorrowingService, IModelMapper iModelMapper) {
        this.bookBorrowingService = bookBorrowingService;
        this.iModelMapper = iModelMapper;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<BookBorrowResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<BookBorrow> bookBorrows = this.bookBorrowingService.cursor(page, pageSize);
        Page<BookBorrowResponse> bookBorrowResponses = bookBorrows
                .map(bookBorrow -> this.iModelMapper.forResponse().map(bookBorrow, BookBorrowResponse.class));
        return ResultHelper.cursor(bookBorrowResponses);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowResponse> save(@Valid @RequestBody BookBorrowSaveRequest bookSaveRequest){
        BookBorrow bookBorrow = this.iModelMapper.forRequest().map(bookSaveRequest,BookBorrow.class);
        this.bookBorrowingService.save(bookBorrow);
        BookBorrowResponse bookResponse = this.iModelMapper.forResponse().map(bookBorrow, BookBorrowResponse.class);
        return new ResultData<>("Data is created","201",true,bookResponse);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowResponse> update(@Valid @RequestBody BookBorrowUpdateRequest bookBorrowUpdateRequest){

        BookBorrow bookBorrow = this.iModelMapper.forRequest().map(bookBorrowUpdateRequest,BookBorrow.class);
        this.bookBorrowingService.update(bookBorrow);
        return ResultHelper.success(this.iModelMapper.forResponse().map(bookBorrow, BookBorrowResponse.class));
    }
}
