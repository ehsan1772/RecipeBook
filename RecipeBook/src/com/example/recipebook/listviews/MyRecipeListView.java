package com.example.recipebook.listviews;

import com.example.recipebook.Recipe;
import com.example.recipebook.activities.MainActivity;
import com.example.recipebook.database.DatabaseTask;
import com.example.recipebook.database.RunQuery;
import com.example.recipebook.dsupporting.MyFragmentManager;
import com.example.recipebook.interfaces.MyListViewOwner;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

/**
 * This class extends ListView and registered appropriate callbacks through
 * implementing OnItemLongClickListener and MyAlterDialogueOwner interfaces It
 * gets added to the activity in the XML layout
 * 
 * @author Ehsan Barekati
 * 
 */
public class MyRecipeListView extends ListView implements OnItemClickListener,
		MyAlterDialogueOwner, OnItemLongClickListener {

	private MyListViewOwner theOwner;
	private Context context;
	private MyAlterDialogue alterDialogue;
	private RunQuery runQuery;
	private MyFragmentManager myFragmentManager;

	public MyRecipeListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
	}

	public MyRecipeListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}

	public MyRecipeListView(Context context) {
		super(context);
		initialize(context);
	}

	/**
	 * gets calls in constructors and registers the onClickListeners
	 * 
	 * @param context
	 */
	private void initialize(Context context) {
		this.context = context;
		this.setOnItemClickListener(this);
		this.setOnItemLongClickListener(this);
		alterDialogue = new MyAlterDialogue(context, this);
	}

	public void setTheOwner(MyListViewOwner theOwner) {
		this.theOwner = theOwner;
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		myFragmentManager = MainActivity.getMyFragmentManager();
		Recipe recipe = (Recipe) theOwner.getClickedItem(arg2);
		MyFragmentManager.setRecipe(recipe);
		myFragmentManager.startRecipeDetail((FragmentActivity) context);

	}

	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
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
	}

}
