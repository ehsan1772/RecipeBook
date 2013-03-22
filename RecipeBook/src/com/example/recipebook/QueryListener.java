
package com.example.recipebook;

import java.util.List;

import android.database.Cursor;

/**
 * The main activity implements this interface to communicate with the search events
 * @author Ehsan Barekati
 *
 */
public interface QueryListener {
	
//	void onSearchComplete(List<BriefResult> data);
	void setCursor(Cursor cursor);
	void onFindCategoriesComplete(List<String> categories);

}
