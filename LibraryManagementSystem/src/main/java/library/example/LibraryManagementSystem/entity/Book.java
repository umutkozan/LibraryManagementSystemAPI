package library.example.LibraryManagementSystem.entity;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.Flow;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_author_id", referencedColumnName ="author_id")
    private Author author;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="book_categories",
            joinColumns = {
                    @JoinColumn(name = "book_category_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_category_category_id")}
    )
    private List <Category> categoryList;

    @ManyToOne
    @JoinColumn(name="book_publisher_id", referencedColumnName ="publisher_id")
    private Flow.Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST,fetch =FetchType.LAZY)
    private List<BookBorrow> bookBorrowings;


    @Column(name = "book_name",length = 100, nullable = false, unique = true)
    private String name;

    @Column(name=   "publication_year", nullable = false)
    private Integer publication_year;

    @Column(name="stock_count", nullable = false)
    private Integer book_stock;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publication_year +
                ", book_stock=" + book_stock +
                '}';
    }

}

