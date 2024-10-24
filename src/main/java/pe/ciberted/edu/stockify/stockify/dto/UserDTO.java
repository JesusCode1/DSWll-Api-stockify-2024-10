package pe.ciberted.edu.stockify.stockify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.ciberted.edu.stockify.stockify.entity.User.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;
    private Status status;
    private String locationName;
    private int locationId;
}
