package com.example.recipebook.activities;

import java.util.List;

import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.database.MyDatabaseHelper;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.interfaces.MyDatabaseOwner;
import com.example.recipebook.interfaces.QueryListener;
import com.example.recipebook.listviews.MyCategoryListView;

import android.os.Bundle;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends SuperActivity implements MyDatabaseOwner, QueryListener{

	private MyDatabaseHelper myDatabaseHelper;
	private MyCategoryListView categoryListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        myDatabaseHelper = new MyDatabaseHelper(this, "assignment4.db", null, 1, this);
        
        RunQuery.db = myDatabaseHelper.getWritableDatabase();
        
        setContentView(R.layout.activity_main);
        
     //   categoryListView = (MyCategoryListView) findViewById(R.id.categorylistView);

    }


	public void datatabaseInitializationStart() {
		// TODO Auto-generated method stub
		
	}

	public void datatabaseInitializationDone() {
		// TODO Auto-generated method stub
		
	}

	public void setCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	public void onFindCategoriesComplete(List<String> categories) {
		
		
	}

	public void onFindRecipesComplete(List<Recipe> recipes) {
		// TODO Auto-generated method stub
		
	}
}
