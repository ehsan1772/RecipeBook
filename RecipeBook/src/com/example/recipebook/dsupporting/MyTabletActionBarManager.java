package com.example.recipebook.dsupporting;

import com.example.recipebook.R;
import com.example.recipebook.activities.CreateNewActivity;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * This class manages the action bar for the tablet version
 * @author Ehsan Barekati
 *
 */
public class MyTabletActionBarManager extends MyActionBarManager {

	private boolean isHoneyComb;

	public MyTabletActionBarManager(boolean isHoneyComb) {
		this.isHoneyComb = isHoneyComb;
	}

	/**
	 * This method finds which activity is getting created and inflates the respective menu
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
	 * reacts to the clicks on the items in the action bar 
	 */
	@Override
	public boolean onOptionsItemSelected(FragmentActivity activity,
			MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (!(activity instanceof MainActivity)) {
				Intent intent = new Intent(activity, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				activity.startActivity(intent);
			}
			return true;
		case R.id.create_new:
			MainActivity.getMyFragmentManager().startCreateNew(activity);
			return true;
		default:
			return false;
		}
	}

}
