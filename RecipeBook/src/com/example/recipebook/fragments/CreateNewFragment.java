package com.example.recipebook.fragments;

import java.util.ArrayList;
import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.activities.CreateNewActivity;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.interfaces.QueryListener;

import android.R.color;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CreateNewFragment extends Fragment implements QueryListener {
	
	private View root;
	private EditText name;
	private Spinner category;
	private EditText time;
	private EditText ingredients;
	private EditText instructions;
	private RunQuery runQuery;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 root = inflater.inflate(R.layout.create_new, container, false);
		 
		 name = (EditText) root.findViewById(R.id.name);
		 time = (EditText) root.findViewById(R.id.time);
		 category = (Spinner) root.findViewById(R.id.category_list);
		 ingredients = (EditText) root.findViewById(R.id.ingredients);
		 instructions = (EditText) root.findViewById(R.id.instructions);
		 
		 name.setBackgroundColor(Color.WHITE);
		 time.setBackgroundColor(Color.WHITE);
		 category.setBackgroundColor(Color.WHITE);
		 ingredients.setBackgroundColor(Color.WHITE);
		 instructions.setBackgroundColor(Color.WHITE);
		 
		 setHasOptionsMenu(true);
		 
		 setCategories();
		 return root;
	}



	private void setCategories(){
		runQuery = new RunQuery(DatabaseTask.FIND_CATEGORIES, this);
		runQuery.execute();
	}

	public void onFindCategoriesComplete(List<String> categories) {
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, categories);
		category.setAdapter(spinnerArrayAdapter);
		
	}

	public void onFindRecipesComplete(List<Recipe> recipes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.option_menu_create_new, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
        case R.id.save:
        	saveIt();

    		MyFragmentManager myFragmentManager = MainActivity.getMyFragmentManager();
    		MyFragmentManager.setRecipe(getRecipe());
    		myFragmentManager.startRecipeDetail(getActivity());
    		
        	return true;
	    }
		return super.onOptionsItemSelected(item);
	}
	
	private Recipe getRecipe() {
		Recipe recipe = new Recipe();
		
		recipe.setName(name.getText().toString());
		recipe.setCategory(category.getSelectedItem().toString());
		recipe.setMinutes(time.getText().toString());
		recipe.setIngredients(ingredients.getText().toString());
		recipe.setInstructions(instructions.getText().toString());
		
		return recipe;
	}



	private void saveIt(){
		runQuery = new RunQuery(DatabaseTask.CREATE_NEW, this);
		runQuery.execute(input());
	}
	
	private String[] input(){
		String[] input = new String[5];
		input[0] = (name.getText().toString());
		input[1] = (time.getText().toString());
		input[2] = (category.getSelectedItem().toString());
		input[3] = (ingredients.getText().toString());
		input[4] = (instructions.getText().toString());
		
		return input;
	}
	
	
}
