package com.example.recipebook.dsupporting;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * This is an abstract class that can get extended several times based on the different behavior that we expect from the actionBarManager on different devices
 * @author Ehsan Barekati
 *
 */
public abstract class MyActionBarManager {
	
	//protected Activity activity;
	
	public abstract boolean onCreateOptionsMenu(FragmentActivity activity, Menu menu);
	public abstract boolean onOptionsItemSelected(FragmentActivity activity, MenuItem item);
}
