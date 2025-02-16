package az.coders.spring.category.mvc.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_categories", allocationSize = 1)
   @Column(name = "category_id", length = 10, nullable = false)
    private int id;
    @Column(name = "category_name")
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
