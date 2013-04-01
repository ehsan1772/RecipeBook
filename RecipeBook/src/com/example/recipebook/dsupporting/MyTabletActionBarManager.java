package com.example.recipebook.dsupporting;

import com.example.recipebook.R;
import com.example.recipebook.fragments.CreateNewFragment;
import com.example.recipebook.fragments.RecipeDetailFragment;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MyTabletActionBarManager extends MyActionBarManager {

	private boolean isHoneyComb;
	
	public MyTabletActionBarManager(boolean isHoneyComb){
	this.isHoneyComb = isHoneyComb;	
	}

	@Override
	public boolean onCreateOptionsMenu(FragmentActivity activity, Menu menu) {
		MenuInflater inflator = activity.getMenuInflater();
		inflator.inflate(R.menu.option_menu, menu);

		return true;
	}

	@Override
	public void initialize(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onOptionsItemSelected(FragmentActivity activity, MenuItem item) {
	    switch (item.getItemId()) {
	    
	    case R.id.create_new:
        FragmentManager fragmentManager = activity.getSupportFragmentManager();		   
        CreateNewFragment thirdFragment = new CreateNewFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.third_layout, thirdFragment);
        transaction.commit();
        return true;
        default:
        	return false;
	    }
	}



}
