package com.example.recipebook.fragments;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.R.id;
import com.example.recipebook.R.layout;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.interfaces.MyListViewOwner;
import com.example.recipebook.interfaces.QueryListener;
import com.example.recipebook.listviews.CategoryViewAdapter;
import com.example.recipebook.listviews.MyCategoryListView;

//import android.app.Fragment;
import android.R.color;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class CategoryListFragment extends Fragment implements QueryListener, MyListViewOwner{

	private MyCategoryListView listView;
	private View root;
	private RunQuery runQuery;
	private List<String> categories;
	private CategoryViewAdapter categoryViewAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		 root = inflater.inflate(R.layout.category_item_view, container, false);
		 listView = (MyCategoryListView) root.findViewById(R.id.categorylistView);
		 listView.setTheOwner(this);
		 setCategories();
		 
		 
		 
		 return root;
	}
	
	private void setCategories(){
		runQuery = new RunQuery(DatabaseTask.FIND_CATEGORIES, this);
		runQuery.execute();
	}
	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}
	public void onFindCategoriesComplete(List<String> categories) {
		this.categories = categories;
		categoryViewAdapter = new CategoryViewAdapter(getActivity(), R.layout.category_view, categories);
		listView.setAdapter(categoryViewAdapter);
	}

	public Object getClickedItem(int position) {
		return categories.get(position);
	}

	public void onFindRecipesComplete(List<Recipe> recipes) {
		// TODO Auto-generated method stub
		
	}

	public Cursor getCursor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteClickedItem(int position) {
		// TODO Auto-generated method stub
		
	}

}
