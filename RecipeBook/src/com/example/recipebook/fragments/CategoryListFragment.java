package com.example.recipebook.fragments;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.interfaces.MyListViewOwner;
import com.example.recipebook.interfaces.QueryListener;
import com.example.recipebook.listviews.CategoryViewAdapter;
import com.example.recipebook.listviews.MyCategoryListView;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * This class extends the Fragment class and implements the life cycle call back to display
 * all the categories that are in the database in a listview.
 * 
 * @author Ehsan Barekati
 *
 */
public class CategoryListFragment extends Fragment implements QueryListener,
		MyListViewOwner {

	private MyCategoryListView listView;
	private View root;
	private RunQuery runQuery;
	private List<String> categories;
	private CategoryViewAdapter categoryViewAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.category_item_view, container, false);
		listView = (MyCategoryListView) root
				.findViewById(R.id.categorylistView);
		listView.setTheOwner(this);
		setCategories();
		return root;
	}

	private void setCategories() {
		runQuery = new RunQuery(DatabaseTask.FIND_CATEGORIES, this);
		runQuery.execute();
	}

	public Object getClickedItem(int position) {
		return categories.get(position);
	}

	public Cursor getCursor() {
		return null;
	}

	public void deleteClickedItem(int position) {
	}

	public void setCursor(Cursor cursor) {
	}

	public void onQueryCompleted(Object result) {

		List<String> categories = (List<String>) result;
		this.categories = categories;
		categoryViewAdapter = new CategoryViewAdapter(getActivity(),
				R.layout.category_view, categories);
		listView.setAdapter(categoryViewAdapter);

	}

}
