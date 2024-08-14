package library.example.LibraryManagementSystem.business.concretes;

import library.example.LibraryManagementSystem.business.abstracts.IAuthorService;
import library.example.LibraryManagementSystem.entity.Author;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorManager implements IAuthorService {
    private final AuthorRepo authorRepo;

    public AuthorManager(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }


    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }
    @Override
    public Author update(Author author) {
        if(!authorRepo.existsById(Math.toIntExact(author.getId()))) {
            throw new ChangeSetPersister.NotFoundException("Author with ID " + author.getId() + " does not exist");
        }
        this.get(author.getId());
        return this.authorRepo.save(author);
    }

    @Override
    public Author get(long id) {
        return this.authorRepo.findById((int)id).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Author with ID " + id + " does not exist"));
    }
    public Page<Author> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Author> authorPage = this.authorRepo.findAll(pageable);
        if (authorPage.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException("No authors found");
        }
        return authorPage;
    }
}