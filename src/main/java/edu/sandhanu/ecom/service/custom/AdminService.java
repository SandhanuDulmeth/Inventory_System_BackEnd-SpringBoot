package edu.sandhanu.ecom.service.custom;

public interface AdminService {
    Boolean checkAdminByEmail(String email);

    Boolean checkAdminPasswordByEmail(String email, String password);
}
