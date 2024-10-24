package pe.ciberted.edu.stockify.stockify.services.impl;

import org.springframework.stereotype.Service;
import pe.ciberted.edu.stockify.stockify.dto.CategoryDTO;
import pe.ciberted.edu.stockify.stockify.entity.Category;
import pe.ciberted.edu.stockify.stockify.repository.CategoryRepository;
import pe.ciberted.edu.stockify.stockify.services.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDTO> findById(int id) {
        return categoryRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_name(categoryDTO.getCategoryName());
        category.setCategory_description(categoryDTO.getCategoryDescription());
        Category savedCategory = categoryRepository.save(category);
        return convertToDTO(savedCategory);
    }

    @Override
    public Optional<CategoryDTO> update(int id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setCategory_name(categoryDTO.getCategoryName());
            existing.setCategory_description(categoryDTO.getCategoryDescription());
            categoryRepository.save(existing);
            return convertToDTO(existing);
        });
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(
                category.getCategory_id(),
                category.getCategory_name(),
                category.getCategory_description()
        );
    }
}
