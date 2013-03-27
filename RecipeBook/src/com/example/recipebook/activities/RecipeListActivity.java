package com.example.recipebook.activities;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.R.layout;
import com.example.recipebook.interfaces.MyDatabaseOwner;
import com.example.recipebook.interfaces.QueryListener;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class RecipeListActivity extends SuperActivity implements MyDatabaseOwner, QueryListener{

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
