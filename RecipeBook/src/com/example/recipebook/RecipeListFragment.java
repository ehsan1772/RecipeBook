package com.example.recipebook;

import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecipeListFragment extends Fragment implements QueryListener, MyListViewOwner{
	
	private View root;
	private MyRecipeListView listView;
	private RunQuery runQuery; 
	private RecipeListActivity activity;
	private List<Recipe> recipes;
	private RecipeViewAdapter recipeViewAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 root = inflater.inflate(R.layout.recipe_item_view, container, false);
		 listView = (MyRecipeListView) root.findViewById(R.id.recipelistView);
		 listView.setTheOwner(this);
		 setRecipes();
		 
		 return root;
	}
	
	
	@Override
	public void onAttach(Activity activity) {
		activity = (RecipeListActivity) activity;
		super.onAttach(activity);
	}


	private void setRecipes(){
		runQuery = new RunQuery(DatabaseTask.FIND_RECIPES, this);
		String category = ((RecipeListActivity) this.getActivity()).getCategory();
	//	String category = activity.getCategory();
		Log.d("Category = ", category);
		runQuery.execute(category);
	}
	
	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	public void onFindCategoriesComplete(List<String> categories) {
		// TODO Auto-generated method stub
		
	}

	public Object getClickedItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cursor getCursor() {
		// TODO Auto-generated method stub
		return null;
	}


	public void onFindRecipesComplete(List<Recipe> recipes) {
		this.recipes = recipes;
		recipeViewAdapter = new RecipeViewAdapter(getActivity(), R.layout.category_view, recipes);
		listView.setAdapter(recipeViewAdapter);
	}

}
