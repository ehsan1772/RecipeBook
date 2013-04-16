package com.example.recipebook.activities;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.example.recipebook.dsupporting.MyActionBarManager;
import com.example.recipebook.dsupporting.MyHandsetActionBarManager;
import com.example.recipebook.dsupporting.MyTabletActionBarManager;

/**
 * This is the super class for all the activities in this application.
 * This class recognizes what kind of device the app is running on and creates an instance of the abstract class MyActionBarManager accordingly
 * @author Ehsan Barekati
 *
 */
public class SuperActivity extends FragmentActivity {

	private MyActionBarManager myActionBarManager;
	
	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	}

	/**
	 * 
	 * this callback method gets called to create the option menu.
	 * It will call the constructor of the right subclass of MyActionBarManager and calls the .oncreateoptionmenue on that instance.
	 */
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
	
	
/**
 * This method just passes the selected item to the instance of MyActionManager
 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return myActionBarManager.onOptionsItemSelected(this, item);
		

	}
	
}
