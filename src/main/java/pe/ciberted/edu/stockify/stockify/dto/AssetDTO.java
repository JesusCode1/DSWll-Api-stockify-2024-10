package pe.ciberted.edu.stockify.stockify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDTO {
    private int assetId;
    private String assetName;
    private String assetDescription;
    private String model;
    private String manufacturer;
    private String serialNumber;
    private int categoryId;
    private int locationId;
    private Date purchaseDate;
    private BigDecimal purchasePrice;
    private Date warranty;
    private String assetStatus;
    private String assignedTo;
    private String adminName;
}
