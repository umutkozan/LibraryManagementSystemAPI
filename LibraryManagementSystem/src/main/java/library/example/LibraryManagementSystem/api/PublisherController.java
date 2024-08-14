package library.example.LibraryManagementSystem.api;

import library.example.LibraryManagementSystem.business.abstracts.IPublisherService;
import library.example.LibraryManagementSystem.core.config.modelMapper.IModelMapper;
import library.example.LibraryManagementSystem.core.result.ResultData;
import library.example.LibraryManagementSystem.core.result.ResultHelper;
import library.example.LibraryManagementSystem.dto.response.publisher.PublisherResponse;
import library.example.LibraryManagementSystem.entity.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final IPublisherService iPublisherService;
    private final IModelMapper iModelMapper;


    public PublisherController(IPublisherService iPublisherService, IModelMapper iModelMapper) {
        this.iPublisherService = iPublisherService;
        this.iModelMapper = iModelMapper;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<dev.patika.vetmanagement.dto.response.CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Publisher> publisherPage = this.iPublisherService.cursor(page, pageSize);
        Page<PublisherResponse> publisherResponses = publisherPage
                .map(category -> this.iModelMapper.forResponse().map(category, PublisherResponse.class));
        return ResultHelper.cursor(publisherResponses);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        Publisher savePublisher = this.iModelMapper.forRequest().map(publisherSaveRequest,Publisher.class);
        this.iPublisherService.save(savePublisher);
        PublisherResponse publisherResponse = this.iModelMapper.forResponse().map(savePublisher,PublisherResponse.class);
        return new ResultData<>("Data is created","201",true,publisherResponse);
    }
    //update vaccine
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest){

        Publisher publisher = this.iModelMapper.forRequest().map(publisherUpdateRequest,Publisher.class);
        this.iPublisherService.update(publisher);
        return ResultHelper.success(this.iModelMapper.forResponse().map(publisher,PublisherResponse.class));
    }
}