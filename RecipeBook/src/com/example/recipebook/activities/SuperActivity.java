package com.example.recipebook.activities;

//import android.R;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.recipebook.R;

public class SuperActivity extends FragmentActivity {

	
	@SuppressLint({ "NewApi", "NewApi" })
	@Override
	protected void onCreate(Bundle arg0) {
	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		super.onCreate(arg0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflator = getMenuInflater();
		inflator.inflate(R.menu.option_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
        case android.R.id.home:
 //            app icon in action bar clicked; go home
        	if (!(this instanceof MainActivity))
        	{
            Intent intent = getIntent(this);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        	}
            return true;
        case R.id.create_new:
        	Intent intent = new Intent(this, CreateNewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        default:
            return super.onOptionsItemSelected(item);
    }
	}
	
	private Intent getIntent(FragmentActivity activity){
		Intent intent = null;
		if (activity instanceof RecipeListActivity)
			intent = new Intent(this,  MainActivity.class);
			//return intent;
		if (activity instanceof RecipeDetailActivity)
		{
			intent = new Intent(this,  RecipeListActivity.class);
			intent.putExtra("Category", ((RecipeDetailActivity)this).getCategory());
		}
		return intent;
	}

	
}
