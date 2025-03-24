package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.entity.AdminEntity;
import edu.sandhanu.ecom.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity> {
    Boolean checkAdminByEmail(String email);

    Boolean  checkAdminPasswordByEmail(String email, String password);
}
