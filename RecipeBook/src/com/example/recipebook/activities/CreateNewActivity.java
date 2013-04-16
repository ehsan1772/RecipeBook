package com.example.recipebook.activities;

import com.example.recipebook.R;

import android.os.Bundle;
import android.view.MenuItem;

/**
 * This class extends SuoerActivity and activates the appropriate fragment. the rest will ger handled either by the fragment or by the SuperActivity
 * @author Ehsan Barekati
 *
 */
public class CreateNewActivity extends SuperActivity{

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);		
		setContentView(R.layout.activity_create_new);
	}
	
	
/**
 * we override onOptionSelected method and return false to handle it through the fragment
 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
}

	
}
