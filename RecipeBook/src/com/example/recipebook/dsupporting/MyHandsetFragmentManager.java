package com.example.recipebook.dsupporting;

import com.example.recipebook.activities.CreateNewActivity;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * This class is a concrete extension of MyFragmentClass which implements the
 * methods for the handset devices.
 * 
 * @author Ehsan Barekati
 * 
 */
public class MyHandsetFragmentManager extends MyFragmentManager {

	@Override
	public void startCreateNew(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, CreateNewActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		fActivity.startActivity(intent);

	}

	@Override
	public void startRecipeDetail(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, RecipeDetailActivity.class);
		fActivity.startActivity(intent);
	}

	@Override
	public void startCategoryList(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, RecipeListActivity.class);
		fActivity.startActivity(intent);

	}

	@Override
	public void startRecipeList(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, RecipeListActivity.class);
		fActivity.startActivity(intent);

	}

}
