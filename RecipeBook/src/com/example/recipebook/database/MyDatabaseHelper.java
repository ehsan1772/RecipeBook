
package com.example.recipebook.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.recipebook.interfaces.MyDatabaseOwner;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * This class extends SQLiteOpenHelper class and by overridong the methods and adding new ones, replaces the database that is
 * provided in the "asstes" folder with the created database
 * @author Ehsan Barekati
 *
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{

	private final static String DB_PATH = "/data/data/com.example.recipebook/databases/"; 
    private final static String DB_NAME = "assignment4.db";
    private SQLiteDatabase myDataBase; 
    private Context myContext;
    private MyDatabaseOwner theOwner;
    private InitializeDatabase initializer;
    
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version, MyDatabaseOwner theOwner) {
		super(context, name, factory, version);
		myContext = context;
		this.theOwner = theOwner;
    	try {
			createDataBase();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	openDataBase();

	}

	
    public void createDataBase() throws IOException{
    	boolean dbExist = checkDataBase();
    	if(!dbExist){
    		//By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
        	this.getReadableDatabase();
    		
    		initializer = new InitializeDatabase();
    		initializer.execute();
    		
    	}
    }
    
    private boolean checkDataBase(){   	 
    	SQLiteDatabase checkDB = null;
		String myPath = DB_PATH + DB_NAME;
		try {
		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		} catch (SQLiteException e) {
			return false;
		}
    	if(checkDB != null)
    		checkDB.close();
 
     	return checkDB != null ? true : false;
    }
    
    private void copyDataBase() throws IOException{
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
    }
    
    /**
     * An inner class that extends AsyncTask and copies the database on the phone upon the first initiation
     * @throws SQLException
     */
    public void openDataBase() throws SQLException{
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
    
    
    @Override
	public synchronized void close() {
    	    if(myDataBase != null)
    		    myDataBase.close();
    	    super.close();
	}
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}
	
	private class InitializeDatabase extends AsyncTask<Void, MyDatabaseOwner, Void>{

		@Override
		protected Void doInBackground(Void... params){
			 try {
				MyDatabaseHelper.this.copyDataBase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			MyDatabaseHelper.this.theOwner.datatabaseInitializationDone();
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			MyDatabaseHelper.this.theOwner.datatabaseInitializationStart();
			super.onPreExecute();
		}
		
	}

}
