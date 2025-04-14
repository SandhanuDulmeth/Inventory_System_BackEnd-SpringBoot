package edu.sandhanu.ecom.repository.custom;


import edu.sandhanu.ecom.entity.ProductEntity;
import edu.sandhanu.ecom.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity> {

    ProductEntity save(ProductEntity entity);
}
