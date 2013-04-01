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
//		MenuInflater inflator = getMenuInflater();
//		inflator.inflate(R.menu.option_menu, menu);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//	    ActionBar actionBar = getActionBar();
//	    actionBar.setDisplayHomeAsUpEnabled(true);
//        }
//        
//		return true;
		return myActionBarManager.onCreateOptionsMenu(this,menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return myActionBarManager.onOptionsItemSelected(this, item);
		
//	    switch (item.getItemId()) {
//        case android.R.id.home:
// //            app icon in action bar clicked; go home
//        	if (!(this instanceof MainActivity))
//        	{
//            Intent intent = getIntent(this);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        	}
//            return true;
//        case R.id.create_new:
//        	Intent intent = new Intent(this, CreateNewActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//        default:
//            return super.onOptionsItemSelected(item);
//    }
	}
	
//	private Intent getIntent(FragmentActivity activity){
//		Intent intent = null;
//		if (activity instanceof RecipeListActivity)
//			intent = new Intent(this,  MainActivity.class);
//			//return intent;
//		if (activity instanceof RecipeDetailActivity)
//		{
//			intent = new Intent(this,  RecipeListActivity.class);
//			intent.putExtra("Category", ((RecipeDetailActivity)this).getCategory());
//		}
//		return intent;
//	}

	
}
