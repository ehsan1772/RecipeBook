package com.example.recipebook.activities;

import java.util.List;

import com.example.recipebook.Device;
import com.example.recipebook.R;
import com.example.recipebook.Recipe;
import com.example.recipebook.database.MyDatabaseHelper;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.dsupporting.MyHandsetFragmentManager;
import com.example.recipebook.dsupporting.MyTabletFragmentManager;
import com.example.recipebook.interfaces.MyDatabaseOwner;
import com.example.recipebook.interfaces.QueryListener;
import android.os.Bundle;

public class MainActivity extends SuperActivity implements MyDatabaseOwner, QueryListener{

	private MyDatabaseHelper myDatabaseHelper;
	public static Device myDevice;
	private static MyFragmentManager myFragmentManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        myDatabaseHelper = new MyDatabaseHelper(this, "assignment4.db", null, 1, this);
        
        RunQuery.db = myDatabaseHelper.getWritableDatabase();
        
       
        setContentView(R.layout.activity_main);
        
        if (findViewById(R.id.first_layout) != null){
        	myDevice = Device.TABLET;
        	myFragmentManager = new MyTabletFragmentManager();
        }else{
        	myDevice = Device.PHONE;
        	myFragmentManager = new MyHandsetFragmentManager();
        }
        
        myFragmentManager.startCategoryList(this);
 
    }
	
	public static MyFragmentManager getMyFragmentManager(){
		return myFragmentManager;
	}

	public void onFindCategoriesComplete(List<String> categories) {}
	public void onFindRecipesComplete(List<Recipe> recipes) {}
	public void datatabaseInitializationStart() {}
	public void datatabaseInitializationDone() {}

}
