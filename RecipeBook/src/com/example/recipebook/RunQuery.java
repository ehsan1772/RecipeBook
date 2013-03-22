
package com.example.recipebook;

import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * This class runs all the queries in a background thread and updates the UI after completion
 * @author Ehsan Barekati
 *
 */
public class RunQuery extends AsyncTask<Void, ProgressBar, Object>{
	
	public static SQLiteDatabase db;
	private String query;
	private QueryListener listener;
	private List<Object> intertable;
	private MyQueryManager mySearchManager;
	private DatabaseTask task;
	
	public RunQuery(DatabaseTask task, QueryListener listener)
	{		
		this.query = query;
		this.db = db;
		this.listener = listener;
		this.task = task;
		mySearchManager = new MyQueryManager();
	//	task = DatabaseTask.FIND_CATEGORIES;
		//mySearchManager = new MyQueryManager(listener);
	}

	@Override
	protected Object doInBackground(Void... params) {
		
		switch (task){
		case FIND_CATEGORIES:
			return mySearchManager.getCategories(db);
		}
		return null;
	}
    	


	@Override
	protected void onPostExecute(Object result) {
		switch (task){
		case FIND_CATEGORIES:
			listener.onFindCategoriesComplete((List<String>) result);
		}
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		//searchPhra = searchPhrase.toUpperCase();
		super.onPreExecute();
	}




	
}