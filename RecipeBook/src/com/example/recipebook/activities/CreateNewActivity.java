package com.example.recipebook.activities;

import com.example.recipebook.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CreateNewActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		 setContentView(R.layout.activity_create_new);
	}
	
	//private Category currentCategory;
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflator = getMenuInflater();
//		inflator.inflate(R.menu.option_menu_create_new, menu);
//		return true;
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
        case android.R.id.home:

            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}

}
