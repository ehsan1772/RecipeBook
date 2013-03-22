package com.example.recipebook;

import java.util.List;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoryListFragment extends Fragment implements QueryListener{

	private MyCategoryListView listView;
	private View root;
	private RunQuery runQuery;
	private CategoryViewAdapter categoryViewAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		 root = inflater.inflate(R.layout.category_view, container, false);
		 listView = (MyCategoryListView) root.findViewById(R.id.categorylistView);
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
		// TODO Auto-generated method stub
		categoryViewAdapter = new CategoryViewAdapter(getActivity(), R.layout.category_view, categories);
		listView.setAdapter(categoryViewAdapter);
	}

}
