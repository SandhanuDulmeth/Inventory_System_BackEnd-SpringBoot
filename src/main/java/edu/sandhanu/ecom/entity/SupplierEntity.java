package edu.sandhanu.ecom.entity;

import edu.sandhanu.ecom.util.SupplierStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "contact_person")
    private String contactPerson;

    private String email;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private SupplierStatus status;

    @Column(name = "date_added", insertable = false, updatable = false)
    private LocalDateTime dateAdded;
}