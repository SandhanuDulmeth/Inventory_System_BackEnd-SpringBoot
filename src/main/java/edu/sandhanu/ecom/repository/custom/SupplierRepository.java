package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.entity.SupplierEntity;
import edu.sandhanu.ecom.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface SupplierRepository extends CrudRepository<SupplierEntity> {
    ArrayList<SupplierEntity> gettAll();
    SupplierEntity save(SupplierEntity entity);
}