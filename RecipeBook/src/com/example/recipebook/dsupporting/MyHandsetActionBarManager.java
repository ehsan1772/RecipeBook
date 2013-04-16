package com.example.recipebook.dsupporting;

import com.example.recipebook.R;
import com.example.recipebook.activities.CreateNewActivity;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * This class is a concrete subclass of the MyActionBarManager and implements all the methods for a handset device
 * @author Ehsan Barekati
 *
 */
public class MyHandsetActionBarManager extends MyActionBarManager {

	private boolean isHoneyComb;
	
	public MyHandsetActionBarManager(boolean isHoneyComb){
	this.isHoneyComb = isHoneyComb;	
	}

	/**
	 * Adds the option_menu (from the menu folder) contents to the option menu menu
	 * if the device is running on HonneyComb and above. the menu will be added as an option menu otherwise it will be the old option menu
	 * in the former case, the method activates the "up" navigation on the action menu.
	 */
	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	public boolean onCreateOptionsMenu(FragmentActivity activity, Menu menu) {
		MenuInflater inflator = activity.getMenuInflater();
			
		if (activity instanceof CreateNewActivity)
			inflator.inflate(R.menu.option_menu_create_new, menu);
		if (activity instanceof MainActivity)
			inflator.inflate(R.menu.opteion_menu_main, menu);
		if (activity instanceof RecipeDetailActivity)
			inflator.inflate(R.menu.opteion_menu_detail, menu);
		if (activity instanceof RecipeListActivity)
			inflator.inflate(R.menu.opteion_menu_recipe_list, menu);

        if (isHoneyComb) {
	    ActionBar actionBar = activity.getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
        }
        
		return true;
	}


	/**
	 * Handles the clicks on the option menu items 
	 */
	@Override
	public boolean onOptionsItemSelected(FragmentActivity activity, MenuItem item) {
	    switch (item.getItemId()) {
        case android.R.id.home:
        	if (!(activity instanceof MainActivity))
        	{
            Intent intent = getIntent(activity);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(intent);
        	}
            return true;
        case R.id.create_new:
        	Intent intent = new Intent(activity, CreateNewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            activity.startActivity(intent);
            return true;
        default :
        	return false;

    }
	    
	}

	/**
	 * returns an intent that has the correct activity to navigate to when pushing the "up" button
	 * @param activity
	 * @return
	 */
	private Intent getIntent(FragmentActivity activity){
		Intent intent = null;
		if (activity instanceof RecipeListActivity)
			intent = new Intent(activity,  MainActivity.class);
		if (activity instanceof RecipeDetailActivity)
			intent = new Intent(activity,  RecipeListActivity.class);
		if (activity instanceof CreateNewActivity)
			intent = new Intent(activity,  RecipeListActivity.class);

		return intent;
	}


}
