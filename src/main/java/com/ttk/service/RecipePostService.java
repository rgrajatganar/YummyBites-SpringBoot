package com.ttk.service;

import com.ttk.entity.RecipePost;

public interface RecipePostService {

	RecipePost addRecipe(RecipePost recipe);

	// method to fetch User detail based on uid from db table
	RecipePost getRecipePostDetail(int recipeid);

	//method to modify User detail based on uid from db table
	RecipePost updateRecipePostDetail(RecipePost recipe, int recipeid);

	//method to remove User detail based on uid from db table
	void deleteRecipePostDetail(int recipeid);
}
