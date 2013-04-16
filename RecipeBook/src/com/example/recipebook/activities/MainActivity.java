package com.example.recipebook.activities;

import com.example.recipebook.Device;
import com.example.recipebook.R;
import com.example.recipebook.database.MyDatabaseHelper;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.dsupporting.MyHandsetFragmentManager;
import com.example.recipebook.dsupporting.MyTabletFragmentManager;
import com.example.recipebook.interfaces.MyDatabaseOwner;
import android.os.Bundle;

/**
 * This is the main activity of the application/ It doesn't do much except for setting the content view 
 * to a layout that includes the category fragment on the phone version, and all the other fragments on the tablet version.
 * @author Ehsan Barekati
 *
 */
public class MainActivity extends SuperActivity implements MyDatabaseOwner{

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
        	if(MyFragmentManager.getCategory() != null)
        		myFragmentManager.startRecipeList(this);

        }else{
        	myDevice = Device.PHONE;
        	myFragmentManager = new MyHandsetFragmentManager();
        }
        
       
 

    }
    
    




	public static MyFragmentManager getMyFragmentManager(){
		return myFragmentManager;
	}

	public void datatabaseInitializationStart() {}
	public void datatabaseInitializationDone() {}

}
