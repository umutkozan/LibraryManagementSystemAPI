package library.example.LibraryManagementSystem.business.concretes;

import library.example.LibraryManagementSystem.business.abstracts.ICategoryService;
import library.example.LibraryManagementSystem.entity.Category;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements ICategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }
    public Page<Category> cursor(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page,pageSize);
        Page<Category> categoryPage = this.categoryRepo.findAll(pageable);
        if (categoryPage.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException("No categories found");
        }
        return categoryPage;
    }

}
