
package com.example.recipebook.listviews;

import com.example.recipebook.Recipe;
import com.example.recipebook.activities.RecipeDetailActivity;
import com.example.recipebook.activities.RecipeListActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.interfaces.MyListViewOwner;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

/**
 * This class extends ListView and registered appropriate callbacks through implementing OnItemLongClickListener and MyAlterDialogueOwner interfaces
 * It gets added to the activity in the XML layout
 * @author Ehsan Barekati
 *
 */
public class MyRecipeListView extends ListView implements OnItemClickListener, MyAlterDialogueOwner, OnItemLongClickListener {

	private MyListViewOwner theOwner; 
	private Context context;
	private MyAlterDialogue alterDialogue;
	private RunQuery runQuery;

	
	public MyRecipeListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
		// TODO Auto-generated constructor stub
	}

	public MyRecipeListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
		// TODO Auto-generated constructor stub
	}

	public MyRecipeListView(Context context) {
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
		this.setOnItemLongClickListener(this);
		alterDialogue = new MyAlterDialogue(context, this);
	}
	 
	 public void setTheOwner(MyListViewOwner theOwner){
		 this.theOwner = theOwner;
	 }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Recipe recipe = (Recipe) theOwner.getClickedItem(arg2);
		Intent intent = new Intent(context, RecipeDetailActivity.class);
		intent.putExtra("Recipe", recipe);
		context.startActivity(intent);
		
	}
	
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		alterDialogue.setPosition(arg2);
		alterDialogue.show();
		return false;
	}


	public void onYesClicked(int position) {
		Recipe recipe = (Recipe) theOwner.getClickedItem(position);
		runQuery = new RunQuery(DatabaseTask.DELETE_RECIPE);
		runQuery.execute(recipe.getID());
		
		theOwner.deleteClickedItem(position);
		
	}

	public void onNoClicked(int position) {
		// TODO Auto-generated method stub
		
	}




}
