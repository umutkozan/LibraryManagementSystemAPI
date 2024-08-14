package library.example.LibraryManagementSystem.api;

import library.example.LibraryManagementSystem.business.abstracts.IBookService;
import library.example.LibraryManagementSystem.core.config.modelMapper.IModelMapper;
import library.example.LibraryManagementSystem.core.result.ResultData;
import library.example.LibraryManagementSystem.core.result.ResultHelper;
import library.example.LibraryManagementSystem.dto.response.book.BookResponse;
import library.example.LibraryManagementSystem.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final IBookService iBookService;
    private final IModelMapper iModelMapper;

    public BookController(IBookService iBookService, IModelMapper iModelMapper) {
        this.iBookService = iBookService;
        this.iModelMapper = iModelMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Book> animalPage = this.iBookService.cursor(page, pageSize);
        Page<BookResponse> animalResponsePage = animalPage
                .map(animal -> this.iModelMapper.forResponse().map(animal, BookResponse.class));
        return ResultHelper.cursor(animalResponsePage);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        Book book = this.iModelMapper.forRequest().map(bookSaveRequest,Book.class);
        this.iBookService.save(book);
        BookResponse bookResponse = this.iModelMapper.forResponse().map(book,BookResponse.class);
        return new ResultData<>("Data is created","201",true,bookResponse);
    }

}