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
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MyHandsetActionBarManager extends MyActionBarManager {

	private boolean isHoneyComb;
	
	public MyHandsetActionBarManager(boolean isHoneyComb){
	this.isHoneyComb = isHoneyComb;	
	}

	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	public boolean onCreateOptionsMenu(FragmentActivity activity, Menu menu) {
		MenuInflater inflator = activity.getMenuInflater();
		inflator.inflate(R.menu.option_menu, menu);

        if (isHoneyComb) {
	    ActionBar actionBar = activity.getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
        }
        
		return true;
	}

	@Override
	public void initialize(Activity activity) {
		// TODO Auto-generated method stub
		
	}

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

	private Intent getIntent(FragmentActivity activity){
		Intent intent = null;
		if (activity instanceof RecipeListActivity)
			intent = new Intent(activity,  MainActivity.class);
			//return intent;
		if (activity instanceof RecipeDetailActivity)
		{
			intent = new Intent(activity,  RecipeListActivity.class);
			intent.putExtra("Category", ((RecipeDetailActivity)activity).getCategory());
		}
		return intent;
	}


}
