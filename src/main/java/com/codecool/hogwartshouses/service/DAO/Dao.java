package com.codecool.hogwartshouses.service.DAO;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Dao<T> {

    Optional<T> get(long id);
    public List<T> getAll();
    void add(T t);
    void delete(long id);

}
