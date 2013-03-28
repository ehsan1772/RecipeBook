package com.example.recipebook.dsupporting;

import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class MyHandsetFragmentManager extends MyFragmentManager {

	@Override
	public void startCreateNew() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startRecipeDetail(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, RecipeDetailActivity.class);
		intent.putExtra("Recipe", recipe);
		fActivity.startActivity(intent);
		
	}

	@Override
	public void startCategoryList(FragmentActivity fActivity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startRecipeList(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, RecipeListActivity.class);
		intent.putExtra("Category", category);
		fActivity.startActivity(intent);
		
	}


}
