package com.example.recipebook.activities;

//import android.R;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.recipebook.R;
import com.example.recipebook.dsupporting.MyActionBarManager;
import com.example.recipebook.dsupporting.MyHandsetActionBarManager;
import com.example.recipebook.dsupporting.MyTabletActionBarManager;

public class SuperActivity extends FragmentActivity {

	MyActionBarManager myActionBarManager;
	
	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	}

	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		switch (MainActivity.myDevice){
		case TABLET:
			myActionBarManager = new MyTabletActionBarManager(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB);
			break;
		case PHONE:
			myActionBarManager = new MyHandsetActionBarManager(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB);
		}

		return myActionBarManager.onCreateOptionsMenu(this,menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return myActionBarManager.onOptionsItemSelected(this, item);
		

	}
	
}
