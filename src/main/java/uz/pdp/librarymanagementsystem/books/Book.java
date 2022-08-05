package uz.pdp.librarymanagementsystem.books;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.librarymanagementsystem.authors.Author;
import uz.pdp.librarymanagementsystem.category.Category;

import java.util.Set;


@NoArgsConstructor
@Data

    @Builder
public class Book {
    private Long id;
    private String title;
    private String description;
    private Set<Author> authors; // for get/edit

    private Set<Long> authorsIds; // for insert/update
    private Category category; // for get/edit

    private Long categoryId; // for insert/update
    private String isbn;
    private String year;
    private String imgUrl;

    private Integer quantity;

    private Long id_for_update;


    public Book(Long id, String title, String description, Set<Author> authors, Set<Long> authorsIds,
                Category category, Long categoryId, String isbn, String year, String imgUrl, Integer quantity,
                Long id_for_update) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.authorsIds = authorsIds;
        this.category = category;
        this.categoryId = categoryId;
        this.isbn = isbn;
        this.year = year;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
        this.id_for_update = id_for_update;
    }
}
