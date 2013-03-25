
package com.example.recipebook.interfaces;

import java.util.List;

import com.example.recipebook.Recipe;

import android.database.Cursor;

/**
 * The main activity implements this interface to communicate with the search events
 * @author Ehsan Barekati
 *
 */
public interface QueryListener {

	void onFindCategoriesComplete(List<String> categories);
	void onFindRecipesComplete(List<Recipe> recipes);

}
