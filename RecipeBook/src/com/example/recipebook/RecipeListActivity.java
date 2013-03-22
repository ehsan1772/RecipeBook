package com.example.recipebook;

import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class RecipeListActivity extends FragmentActivity implements MyDatabaseOwner, QueryListener{

	private String category;
	@Override
	protected void onCreate(Bundle arg0) {
		category = getIntent().getExtras().getString("Category");
		super.onCreate(arg0);
		
		 setContentView(R.layout.activity_recipe);
	}
	
	public String getCategory(){
		return category;
	}


	public void onFindCategoriesComplete(List<String> categories) {
		// TODO Auto-generated method stub
		
	}

	public void datatabaseInitializationStart() {
		// TODO Auto-generated method stub
		
	}

	public void datatabaseInitializationDone() {
		// TODO Auto-generated method stub
		
	}

	public void onFindRecipesComplete(List<Recipe> recipes) {
		// TODO Auto-generated method stub
		
	}

}
