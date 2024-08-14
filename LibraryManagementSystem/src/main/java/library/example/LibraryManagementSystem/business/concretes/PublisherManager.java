package library.example.LibraryManagementSystem.business.concretes;

import library.example.LibraryManagementSystem.business.abstracts.IPublisherService;
import library.example.LibraryManagementSystem.entity.Publisher;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PublisherManager implements IPublisherService {
    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }
    public Page<Publisher> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Publisher> publisherPage = this.publisherRepo.findAll(pageable);
        if (publisherPage.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException("No publishers found");
        }
        return publisherPage;
    }
    @Override
    public Publisher update(Publisher publisher) {
        if(!publisherRepo.existsById(Math.toIntExact(publisher.getId()))) {
            throw new ChangeSetPersister.NotFoundException("Publisher with ID " + publisher.getId() + " does not exist");
        }
        this.get(publisher.getId());
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher get(long id) {
        return this.publisherRepo.findById((int)id).orElseThrow(() -> new NotFoundException("Publisher with ID " + id + " does not exist"));
    }

}