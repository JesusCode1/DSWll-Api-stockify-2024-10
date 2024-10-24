package pe.ciberted.edu.stockify.stockify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private int locationId;
    private String locationName;
    private String locationDescription;
}
