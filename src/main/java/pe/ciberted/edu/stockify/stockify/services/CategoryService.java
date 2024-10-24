package pe.ciberted.edu.stockify.stockify.services;

import pe.ciberted.edu.stockify.stockify.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> findAll();
    Optional<CategoryDTO> findById(int id);
    CategoryDTO save(CategoryDTO categoryDTO);
    Optional<CategoryDTO> update(int id, CategoryDTO categoryDTO);
    void deleteById(int id);
}
