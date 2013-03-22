package com.example.recipebook;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity implements MyDatabaseOwner, QueryListener{

	private MyDatabaseHelper myDatabaseHelper;
	private MyCategoryListView categoryListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        myDatabaseHelper = new MyDatabaseHelper(this, "assignment4.db", null, 1, this);
        
        RunQuery.db = myDatabaseHelper.getWritableDatabase();
        
        setContentView(R.layout.activity_main);
        
        categoryListView = (MyCategoryListView) findViewById(R.id.categorylistView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
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
}
