package com.ttk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttk.entity.RecipePost;
import com.ttk.exception.RecipeNotFoundException;
import com.ttk.repository.RecipePostRepository;
import com.ttk.service.RecipePostService;

@Service
public class RecipePostServiceImpl implements RecipePostService {

	@Autowired
	 RecipePostRepository rRepo;
	
	@Override
	public RecipePost addRecipe(RecipePost recipe) {
		return rRepo.save(recipe);
	}

	@Override
	public RecipePost getRecipePostDetail(int recipeid) {
		return rRepo.findById(recipeid).orElseThrow(()-> new RecipeNotFoundException("Recipe Id is nor corrected"));
	}

	@Override
	public RecipePost updateRecipePostDetail(RecipePost recipe, int recipeid) {
		RecipePost UpdateRecipePost = rRepo.findById(recipeid).
				orElseThrow(()-> new RecipeNotFoundException("recipe id is not corrected"));
	
	
		UpdateRecipePost.setRtitle(recipe.getRtitle());
		UpdateRecipePost.setRcontent(recipe.getRcontent());
		rRepo.save(UpdateRecipePost);
		return UpdateRecipePost;
	}

	@Override
	public void deleteRecipePostDetail(int recipeid) {
		RecipePost delRecipePost =rRepo.findById(recipeid).
				orElseThrow(()-> new RecipeNotFoundException("recipe id is not corrected"));
		rRepo.delete(delRecipePost);
		
	}
	
}
