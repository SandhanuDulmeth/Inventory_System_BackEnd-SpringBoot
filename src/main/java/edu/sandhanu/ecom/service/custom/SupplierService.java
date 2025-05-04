package edu.sandhanu.ecom.service.custom;

import edu.sandhanu.ecom.model.Supplier;

import java.util.ArrayList;

public interface SupplierService {
    ArrayList<Supplier> getSuppliers();
    Supplier createSupplier(Supplier supplier);
    Supplier updateSupplier(Integer id, Supplier supplier);
    void deleteSupplier(Integer id);
}