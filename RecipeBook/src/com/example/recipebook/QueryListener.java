
package com.example.recipebook;

import java.util.List;

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
