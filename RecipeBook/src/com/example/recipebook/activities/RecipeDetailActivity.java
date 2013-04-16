package com.example.recipebook.activities;

import com.example.recipebook.R;
import android.os.Bundle;

/**
 * This class extends SuperActivity and is the activity for viewing the recipe in detail. 
 * the respected fragment will handle setting all the views
 * @author Ehsan Barekati
 *
 */
public class RecipeDetailActivity extends SuperActivity{

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_detail);
	}

}
