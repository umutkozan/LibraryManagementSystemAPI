package library.example.LibraryManagementSystem.business.abstracts;


import library.example.LibraryManagementSystem.entity.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save (Category category);
    Page<Category> cursor (int page, int pageSize);


}
