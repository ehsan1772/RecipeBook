package com.example.recipebook.listviews;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * This class extends the Array adapter class and overrides the getView method to inflate the listview with the required view
 * @author Ehsan Barekati
 *
 */
public class RecipeViewAdapter extends ArrayAdapter<Recipe> {

	List<Recipe> listRecipeView;
	private Context context;
	private Recipe recipe;
	private TextView nameTextView;
	private TextView timeTextView;

	public RecipeViewAdapter(Context context, int textViewResourceId,
			List<Recipe> objects) {
		super(context, textViewResourceId, objects);
		listRecipeView = objects;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		recipe = listRecipeView.get(position);

		LayoutInflater inflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflator.inflate(R.layout.category_view, parent, false);

		nameTextView = (TextView) convertView.findViewById(R.id.category_name);

		nameTextView.setText(recipe.getName() + " (Takes : "
				+ recipe.getMinutes() + " minutes)");

		return convertView;
	}

}
