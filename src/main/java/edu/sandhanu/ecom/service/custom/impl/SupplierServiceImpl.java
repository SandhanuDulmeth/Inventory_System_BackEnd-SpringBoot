package edu.sandhanu.ecom.service.custom.impl;

import edu.sandhanu.ecom.entity.SupplierEntity;
import edu.sandhanu.ecom.model.Supplier;
import edu.sandhanu.ecom.repository.custom.SupplierRepository;
import edu.sandhanu.ecom.service.custom.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper mapper;

    @Override
    public ArrayList<Supplier> getSuppliers() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        supplierRepository.gettAll().forEach(entity ->
                suppliers.add(mapper.map(entity, Supplier.class)));
        return suppliers;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        SupplierEntity entity = mapper.map(supplier, SupplierEntity.class);
        SupplierEntity savedEntity = supplierRepository.save(entity);
        return mapper.map(savedEntity, Supplier.class);
    }
}