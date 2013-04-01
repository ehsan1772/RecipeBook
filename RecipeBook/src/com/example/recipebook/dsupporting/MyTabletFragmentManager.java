package com.example.recipebook.dsupporting;

import com.example.recipebook.R;
import com.example.recipebook.fragments.CategoryListFragment;
import com.example.recipebook.fragments.RecipeDetailFragment;
import com.example.recipebook.fragments.RecipeListFragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MyTabletFragmentManager extends MyFragmentManager {

	@Override
	public void startCreateNew() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startRecipeList(FragmentActivity fragmentActivity) {

        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();        
		secondFragment = new RecipeListFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();		        
        transaction.replace(R.id.second_layout, secondFragment);
        transaction.commit();
		
	}


	@Override
	public void startCategoryList(FragmentActivity fActivity) {
	       CategoryListFragment firstFragment = new CategoryListFragment();

	        fActivity.getSupportFragmentManager().beginTransaction()
	                .add(R.id.first_layout, firstFragment).commit();
		
	}


	@Override
	public void startRecipeDetail(FragmentActivity fActivity) {

        FragmentManager fragmentManager = fActivity.getSupportFragmentManager();		   
		thirdFragment = new RecipeDetailFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.third_layout, thirdFragment);
        transaction.commit();

		
	}

}
