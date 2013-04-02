package com.example.recipebook.fragments;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.interfaces.MyListViewOwner;
import com.example.recipebook.interfaces.QueryListener;
import com.example.recipebook.listviews.MyRecipeListView;
import com.example.recipebook.listviews.RecipeViewAdapter;

import android.R.color;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeListFragment extends Fragment implements QueryListener, MyListViewOwner{
	
	private View root;
	private MyRecipeListView listView;
	private RunQuery runQuery; 
	private List<Recipe> recipes;
	private RecipeViewAdapter recipeViewAdapter;
	private TextView categoryTextView;
	private String category;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 root = inflater.inflate(R.layout.recipe_item_view, container, false);
		 categoryTextView  = (TextView) root.findViewById(R.id.recipe_list_title);
		 listView = (MyRecipeListView) root.findViewById(R.id.recipelistView);
		 listView.setTheOwner(this);
		 category = MyFragmentManager.getCategory();
		 categoryTextView.setText(category);
		 categoryTextView.setBackgroundColor(Color.argb(100, 100, 100, 100));
		 setRecipes();
		 
		 return root;
	}
	
	private void setRecipes(){
		runQuery = new RunQuery(DatabaseTask.FIND_RECIPES, this);
		runQuery.execute(category);
	}
	
	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	public void onFindCategoriesComplete(List<String> categories) {
		// TODO Auto-generated method stub
		
	}

	public Object getClickedItem(int position) {
		return recipes.get(position);
	}

	public Cursor getCursor() {
		// TODO Auto-generated method stub
		return null;
	}


	public void onFindRecipesComplete(List<Recipe> recipes) {
		if (recipes == null || recipes.isEmpty()){
			Toast.makeText(getActivity(), "There is no recipe in this category", Toast.LENGTH_LONG).show();
		}else{
		this.recipes = recipes;
		recipeViewAdapter = new RecipeViewAdapter(getActivity(), R.layout.category_view, recipes);
		listView.setAdapter(recipeViewAdapter);
		}
	}


	public void deleteClickedItem(int position) {
		recipeViewAdapter.remove(recipes.get(position));
	}


	public void addNewFragment(String category) {
		// TODO Auto-generated method stub
		
	}


	public void invokeActivityMethod(Object object) {
		// TODO Auto-generated method stub
		
	}

}
