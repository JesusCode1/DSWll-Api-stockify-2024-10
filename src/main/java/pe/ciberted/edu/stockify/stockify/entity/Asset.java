package pe.ciberted.edu.stockify.stockify.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Assets")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int asset_id;
    private String asset_name;
    private String asset_description;
    private String model;
    private String manufacturer;
    private String serial_number;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "location_id")
    private Location location;

   private Date purchase_date;
   private BigDecimal purchase_price;
   private Date warranty;

   @Enumerated(EnumType.STRING)
    private  AssetStatus asset_status;

   @ManyToOne
   @JsonIgnore
   @JoinColumn(name = "assigned_to", referencedColumnName = "user_id")
   private User assigned_to;

   @ManyToOne
   @JsonIgnore
   @JoinColumn(name ="admin_id")
   private Admin admin;

    public enum AssetStatus {
        available,
        assigned,
        dispose,
        reserved
    }

}
