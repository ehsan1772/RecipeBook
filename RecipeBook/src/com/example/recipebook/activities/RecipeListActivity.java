package com.example.recipebook.activities;

import com.example.recipebook.R;
import android.os.Bundle;

/**
 * This class extends SuperActivity and set the contentview
 * the respected fragment handles all the rest.
 * @author Ehsan Barekati
 *
 */
public class RecipeListActivity extends SuperActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_recipe);
	}


}
