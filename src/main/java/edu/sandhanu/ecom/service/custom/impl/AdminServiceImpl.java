package edu.sandhanu.ecom.service.custom.impl;

import edu.sandhanu.ecom.repository.custom.AdminRepository;
import edu.sandhanu.ecom.service.custom.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper mapper;

    @Override
    public Boolean checkAdminByEmail(String email) {
        return adminRepository.checkAdminByEmail(email);
    }
}
