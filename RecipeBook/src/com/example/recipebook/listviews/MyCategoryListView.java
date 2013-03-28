
package com.example.recipebook.listviews;

import com.example.recipebook.Device;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.activities.RecipeListActivity;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.interfaces.MyListViewOwner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * This class extends ListView and registered appropriate callbacks through implementing OnItemLongClickListener and MyAlterDialogueOwner interfaces
 * It gets added to the activity in the XML layout
 * @author Ehsan Barekati
 *
 */
public class MyCategoryListView extends ListView implements OnItemClickListener {

	private MyListViewOwner theOwner; 
	private Context context;
	private MyFragmentManager myFragmentManager;

	
	public MyCategoryListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
		// TODO Auto-generated constructor stub
	}

	public MyCategoryListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
		// TODO Auto-generated constructor stub
	}

	public MyCategoryListView(Context context) {
		super(context);
		initialize(context);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * gets calls in constructors and registers the onClickListeners
	 * @param context
	 */
	private void initialize(Context context){
		this.context = context;
		this.setOnItemClickListener(this);

			
	}
	 
	 public void setTheOwner(MyListViewOwner theOwner){
		 this.theOwner = theOwner;
	 }
	 

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		myFragmentManager = MainActivity.getMyFragmentManager();
		String category = (String) theOwner.getClickedItem(arg2);
		MyFragmentManager.setCategory(category);
		myFragmentManager.startRecipeList((FragmentActivity) context);
	}





}
