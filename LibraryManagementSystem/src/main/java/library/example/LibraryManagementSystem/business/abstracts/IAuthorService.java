package library.example.LibraryManagementSystem.business.abstracts;

import library.example.LibraryManagementSystem.entity.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService{
    Author save (Author author);
    Author update(Author author);
    Author get(long id);
    Page<Author> cursor (int page, int pageSize);



}