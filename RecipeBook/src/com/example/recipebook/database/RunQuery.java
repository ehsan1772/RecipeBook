
package com.example.recipebook.database;

import com.example.recipebook.interfaces.QueryListener;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * This class runs all the queries in a background thread and updates the UI after completion
 * @author Ehsan Barekati
 *
 */
public class RunQuery extends AsyncTask<String, ProgressBar, Object>{
	
	public static SQLiteDatabase db;
	private QueryListener listener;
	private MyQueryManager mySearchManager;
	private DatabaseTask task;
	
	/**
	 * 
	 * @param task an enumerated type that defines what hind of query should be performed
	 * @param listener the class that is interested in the results of the query. the class should implement QueryListener interface
	 */
	public RunQuery(DatabaseTask task, QueryListener listener)
	{		

		this.listener = listener;
		this.task = task;
		mySearchManager = new MyQueryManager();

	}
	
	/**
	 * This constructor only takes one arguments for the instances where the initiator is not interested in the results of the query
	 * @param task
	 */
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
    	

/**
 * invokes the onQueryCompleted method and send the results back to the initiator
 */
	@Override
	protected void onPostExecute(Object result) {
		if (listener != null)
			listener.onQueryCompleted(result);
		super.onPostExecute(result);
	}

	
}
