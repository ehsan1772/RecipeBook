
package com.example.recipebook.database;

import java.util.List;

import com.example.recipebook.Recipe;
import com.example.recipebook.interfaces.QueryListener;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * This class runs all the queries in a background thread and updates the UI after completion
 * @author Ehsan Barekati
 *
 */
public class RunQuery extends AsyncTask<String, ProgressBar, Object>{
	
	public static SQLiteDatabase db;
	private String query;
	private QueryListener listener;
	private List<Object> intertable;
	private MyQueryManager mySearchManager;
	private DatabaseTask task;
	
	public RunQuery(DatabaseTask task, QueryListener listener)
	{		

		this.listener = listener;
		this.task = task;
		mySearchManager = new MyQueryManager();

	}
	
	public RunQuery(DatabaseTask task)
	{		

		this.task = task;
		mySearchManager = new MyQueryManager();

	}

	@Override
	protected Object doInBackground(String... params) {
		
		switch (task){
		case FIND_CATEGORIES:
			return mySearchManager.getCategories(db);
		case FIND_RECIPES:
			return mySearchManager.getRecipies(params[0], db);
		case CREATE_NEW:
			mySearchManager.createNew(params, db);
			break;
		case DELETE_RECIPE:
			mySearchManager.deleteRecipe(params[0], db);
			break;
		}
		return null;
	}
    	


	@Override
	protected void onPostExecute(Object result) {
		switch (task){
		case FIND_CATEGORIES:
			listener.onFindCategoriesComplete((List<String>) result);
			break;
		case FIND_RECIPES:
			listener.onFindRecipesComplete((List<Recipe>) result);
			break;

		}
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		//searchPhra = searchPhrase.toUpperCase();
		super.onPreExecute();
	}




	
}
