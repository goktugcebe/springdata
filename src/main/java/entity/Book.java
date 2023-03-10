package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name",length = 100,nullable = false,unique = false)
    private String name;

    @Column(name = "pages",nullable = false)
    private int pages;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "publisher_id",nullable = false)
    private Publisher publisher;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    public Book(String name, int pages,Language language, Author author,Category category,Publisher publisher) {
        this.name = name;
        this.pages = pages;
        this.language=language;
        this.author = author;
        this.category=category;
        this.publisher=publisher;
    }
}
