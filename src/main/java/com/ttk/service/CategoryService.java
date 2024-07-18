package com.ttk.service;

import com.ttk.entity.Category;

public interface CategoryService {
	
	Category addCategory(Category category);

	// method to fetch User detail based on uid from db table
	Category getCategoryDetail(int categoryid);

	//method to modify User detail based on uid from db table
	Category updateCategoryDetail(Category category, int categoryid);

	//method to remove User detail based on uid from db table
	void deleteCategoryDetail(int categoryid);

}
