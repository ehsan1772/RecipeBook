package com.example.recipebook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.listviews.MyAlterDialogue;
import com.example.recipebook.listviews.MyAlterDialogueOwner;

/**
 * This class extends the Fragment class. and displays the assigned recipe on
 * the view it also a "Delete" button to the option menu and uses a dialogue
 * with two buttons to confirm deletion of the recipe
 * 
 * @author Ehsan Barekati
 * 
 */
public class RecipeDetailFragment extends Fragment implements
		MyAlterDialogueOwner {

	private View root;
	private Recipe recipe;
	private TextView recipeName;
	private TextView recipeTime;
	private TextView recipeCategory;
	private TextView recipeIngredients;
	private TextView recipeInstruction;
	private RunQuery runQuery;
	private MyAlterDialogue alterDialogue;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		root = inflater.inflate(R.layout.recipe_detail_view, container, false);

		recipeName = (TextView) root.findViewById(R.id.recipe_name);
		recipeTime = (TextView) root.findViewById(R.id.recipe_time);
		recipeCategory = (TextView) root.findViewById(R.id.recipe_category);
		recipeIngredients = (TextView) root
				.findViewById(R.id.recipe_ingredients);
		recipeInstruction = (TextView) root
				.findViewById(R.id.recipe_instructions);

		setRecipes();
		setHasOptionsMenu(true);
		setContent();

		return root;
	}

	/**
	 * gets the recipe from the MyFragmentManager
	 */
	private void setRecipes() {
		recipe = MyFragmentManager.getRecipe();
	}

	private void setContent() {
		recipeName.setText(recipe.getName());
		recipeTime.setText(recipe.getMinutes());
		recipeCategory.setText(recipe.getCategory());
		recipeIngredients.setText(recipe.getIngredients());
		recipeInstruction.setText(recipe.getInstructions());
	}

	/**
	 * handles the clicks on the "Delete" button by displaying a dialogue
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.delete:
			alterDialogue = new MyAlterDialogue(getActivity(), this);
			alterDialogue.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * upon clicking yes on the dialogue the recipe get deleted and the
	 * recipelistactivity will get started through an intent
	 */
	public void onYesClicked(int position) {
		runQuery = new RunQuery(DatabaseTask.DELETE_RECIPE);
		runQuery.execute(recipe.getID());
		MainActivity.getMyFragmentManager().startRecipeList(getActivity());

	}

	public void onNoClicked(int position) {
	}
}
