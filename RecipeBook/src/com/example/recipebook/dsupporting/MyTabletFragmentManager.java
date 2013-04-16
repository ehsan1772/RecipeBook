package com.example.recipebook.dsupporting;

import com.example.recipebook.R;
import com.example.recipebook.activities.CreateNewActivity;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.fragments.CategoryListFragment;
import com.example.recipebook.fragments.RecipeListFragment;
import com.example.recipebook.activities.MainActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * This class implements MyFragmentManager class for the tablet version
 * @author Ehsan Barekati
 * 
 */
public class MyTabletFragmentManager extends MyFragmentManager {

	@Override
	public void startCreateNew(FragmentActivity fActivity) {
		Intent intent = new Intent(fActivity, CreateNewActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		fActivity.startActivity(intent);
	}

	@Override
	public void startRecipeList(FragmentActivity fragmentActivity) {
		if (fragmentActivity instanceof MainActivity) {
			FragmentManager fragmentManager = fragmentActivity
					.getSupportFragmentManager();
			secondFragment = new RecipeListFragment();
			FragmentTransaction transaction = fragmentManager
					.beginTransaction();
			transaction.replace(R.id.second_layout, secondFragment);
			transaction.commit();
		} else {
			Intent intent = new Intent(fragmentActivity, MainActivity.class);
			fragmentActivity.startActivity(intent);
		}

	}

	@Override
	public void startCategoryList(FragmentActivity fActivity) {
		CategoryListFragment firstFragment = new CategoryListFragment();
		fActivity.getSupportFragmentManager().beginTransaction()
				.add(R.id.first_layout, firstFragment).commit();

	}

	@Override
	public void startRecipeDetail(FragmentActivity fActivity) {

		Intent intent = new Intent(fActivity, RecipeDetailActivity.class);
		fActivity.startActivity(intent);

	}

}
