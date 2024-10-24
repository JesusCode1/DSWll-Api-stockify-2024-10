package pe.ciberted.edu.stockify.stockify.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "Location")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;
    private String location_name;
    private String location_description;

}
