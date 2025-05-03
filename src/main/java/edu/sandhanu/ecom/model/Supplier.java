package edu.sandhanu.ecom.model;

import edu.sandhanu.ecom.util.SupplierStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private Integer id;
    private String name;
    private String contactPerson;
    private String email;
    private String phone;
    private String address;
    private SupplierStatus status;
    private LocalDateTime dateAdded;
}