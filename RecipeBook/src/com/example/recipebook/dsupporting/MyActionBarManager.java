package com.example.recipebook.dsupporting;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class MyActionBarManager {
	
	protected Activity activity;
	
	public abstract boolean onCreateOptionsMenu(FragmentActivity activity, Menu menu);
	public abstract void initialize(Activity activity);
	public abstract boolean onOptionsItemSelected(FragmentActivity activity, MenuItem item);
}
