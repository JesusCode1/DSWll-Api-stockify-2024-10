package pe.ciberted.edu.stockify.stockify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private int adminId;
    private String name;
    private String email;
    private String username;
}
