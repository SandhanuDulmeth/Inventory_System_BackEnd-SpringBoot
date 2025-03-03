package edu.sandhanu.ecom.repository;


import java.util.ArrayList;

public interface CrudRepository<T> extends SuperRepository {
    ArrayList<T> gettAll();

}
