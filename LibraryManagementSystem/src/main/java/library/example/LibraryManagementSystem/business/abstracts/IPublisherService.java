package library.example.LibraryManagementSystem.business.abstracts;

import library.example.LibraryManagementSystem.entity.Publisher;
import org.springframework.data.domain.Page;

public interface IPublisherService {
    Publisher save (Publisher publisher);
    Page<Publisher> cursor (int page, int pageSize);
    Publisher update(Publisher publisher);
    Publisher get(long id);

}
