package pe.ciberted.edu.stockify.stockify.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Admins")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int admin_id;
    private String name;
    private String email;
    private String username;
    private String password;
}
