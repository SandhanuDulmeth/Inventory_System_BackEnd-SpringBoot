package edu.sandhanu.ecom.repository.custom;

import edu.sandhanu.ecom.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
}
