package library.example.LibraryManagementSystem.api;

import library.example.LibraryManagementSystem.business.abstracts.IAuthorService;
import library.example.LibraryManagementSystem.core.config.modelMapper.IModelMapper;
import library.example.LibraryManagementSystem.core.result.ResultData;
import library.example.LibraryManagementSystem.core.result.ResultHelper;
import library.example.LibraryManagementSystem.dto.request.author.AuthorSaveRequest;
import library.example.LibraryManagementSystem.dto.request.author.AuthorUpdateRequest;
import library.example.LibraryManagementSystem.dto.response.author.AuthorResponse;
import library.example.LibraryManagementSystem.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {
    private final IAuthorService iAuthorService;
    private final IModelMapper iModelMapper;

    public AuthorController(IAuthorService iAuthorService, IModelMapper iModelMapper) {
        this.iAuthorService = iAuthorService;
        this.iModelMapper = iModelMapper;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<AuthorResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Author> authorPage = this.iAuthorService.cursor(page, pageSize);
        Page<AuthorResponse> authorResponsePage = authorPage
                .map(author -> this.iModelMapper.forResponse().map(author, AuthorResponse.class));
        return ResultHelper.cursor(authorResponsePage);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {
        Author author = this.iModelMapper.forRequest().map(authorSaveRequest, Author.class);
        this.iAuthorService.save(author);
        AuthorResponse authorResponse = this.iModelMapper.forResponse().map(author, AuthorResponse.class);
        return ResultHelper.created(this.iModelMapper.forResponse().map(authorResponse, AuthorResponse.class));

    }
    //update vaccine
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest){

        Author author = this.iModelMapper.forRequest().map(authorUpdateRequest,Author.class);
        this.iAuthorService.update(author);
        return ResultHelper.success(this.iModelMapper.forResponse().map(author,AuthorResponse.class));
    }

}