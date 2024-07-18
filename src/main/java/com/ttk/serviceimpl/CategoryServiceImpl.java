package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.BookShelf;
import com.ttk.entity.Category;
import com.ttk.exception.BookShelfNotFoundException;
import com.ttk.exception.CategoryNotFoundException;
import com.ttk.repository.CategoryRepository;
import com.ttk.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository cRepo;
	
	@Override
	public Category addCategory(Category category) {
		return cRepo.save(category);
	}

	@Override
	public Category getCategoryDetail(int categoryid) {
		return cRepo.findById(categoryid).orElseThrow(()-> new CategoryNotFoundException("Category Id is nor corrected"));

	}

	@Override
	public Category updateCategoryDetail(Category category, int categoryid) {
		Category UpdateCategory = cRepo.findById(categoryid).
				orElseThrow(()-> new CategoryNotFoundException("categoryid is not corrected"));
	
		UpdateCategory.setCname(category.getCname());
		cRepo.save(UpdateCategory);
		return UpdateCategory;
	}

	@Override
	public void deleteCategoryDetail(int categoryid) {
		Category delCategory =cRepo.findById(categoryid).
				orElseThrow(()-> new CategoryNotFoundException("Category id is not corrected"));
		cRepo.delete(delCategory);
		
	}

}
