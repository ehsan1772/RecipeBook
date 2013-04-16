package com.example.recipebook.fragments;

import java.util.List;
import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.interfaces.QueryListener;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This class extends the Fragment class and collects the user input to create a new recipe
 * @author Ehsan Barekati
 *
 */
public class CreateNewFragment extends Fragment implements QueryListener,
		OnClickListener {

	private View root;
	private EditText name;
	private Button saveButton;
	private Spinner category;
	private EditText time;
	private EditText ingredients;
	private EditText instructions;
	private RunQuery runQuery;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.create_new, container, false);
		saveButton = (Button) root.findViewById(R.id.save_button);
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
		saveButton.setOnClickListener(this);
		setCategories();
		return root;
	}

	private void setCategories() {
		runQuery = new RunQuery(DatabaseTask.FIND_CATEGORIES, this);
		runQuery.execute();
	}

	/**
	 * The only button in the option menu is the home button which gets handled
	 * here by staring the recipelist activity through MyFragmentManager
	 * instance
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		MyFragmentManager.setCategory(category.getSelectedItem().toString());
		MyFragmentManager myFragmentManager = MainActivity
				.getMyFragmentManager();
		myFragmentManager.startRecipeList(getActivity());
		return true;

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

	/**
	 * This method gathers the users input and sends it to a background thread
	 * to be persisted in the database And starts the recipe detail activity
	 */
	private void saveIt() {
		String[] input = input();
		if (input != null) {
			runQuery = new RunQuery(DatabaseTask.CREATE_NEW, this);
			runQuery.execute(input);

			MyFragmentManager myFragmentManager = MainActivity
					.getMyFragmentManager();
			MyFragmentManager.setRecipe(getRecipe());
			myFragmentManager.startRecipeDetail(getActivity());
		} else {
			Toast.makeText(getActivity(),
					"Please enter a valid entry in all fields",
					Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * Converts the users input to an array of string
	 * 
	 * @return A String[] representing users input
	 */
	private String[] input() {
		String[] input = new String[5];
		input[0] = (name.getText().toString());
		input[1] = (time.getText().toString());
		input[2] = (category.getSelectedItem().toString());
		input[3] = (ingredients.getText().toString());
		input[4] = (instructions.getText().toString());

		for (int i = 0; i < input.length; i++) {
			if (input[i].isEmpty())
				return null;
		}

		return input;
	}

	public void onQueryCompleted(Object result) {
		if (result instanceof List) {
			List<String> categories = (List<String>) result;
			ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
					getActivity(),
					android.R.layout.simple_spinner_dropdown_item, categories);
			category.setAdapter(spinnerArrayAdapter);
		}

	}

	public void onClick(View v) {
		saveIt();
	}

}
