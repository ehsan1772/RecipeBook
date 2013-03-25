
package com.example.recipebook.listviews;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.R.id;
import com.example.recipebook.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * A basic view adapter that follows the veiwHolder pattern
 * @author Ehsan Barekati
 *
 */
public class CategoryViewAdapter extends ArrayAdapter<String>{
	

	List<String> listCategoryView;
	Context context;
	String category;
	private TextView textView;
	
	public CategoryViewAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		listCategoryView = objects;
		this.context = context;
		// TODO Auto-generated constructor stub
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		category = listCategoryView.get(position);
		

		LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflator.inflate(R.layout.category_view, parent, false);

		textView = (TextView) convertView.findViewById(R.id.category_name);

		textView.setText(category);
	
		return convertView;

		
	}




}
