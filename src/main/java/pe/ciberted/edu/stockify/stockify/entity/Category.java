package pe.ciberted.edu.stockify.stockify.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "Category")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String category_name;
    private String category_description;

}
