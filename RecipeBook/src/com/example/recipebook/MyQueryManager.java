
package com.example.recipebook;

import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * This class offers different methods to perform queries on the database
 * @author Ehsan Barekati
 *
 */
public class MyQueryManager {
	
	private Cursor cursor;
//	private List<BriefResult> listResult;
	private String query;
	private QueryListener onSearchListener;
	
	
	public MyQueryManager(){

	}
	
//	public MyQueryManager(QueryListener onSearchListener){
//		listResult = new ArrayList<BriefResult>();
//		this.onSearchListener = onSearchListener;
//	}
	
	/**
	 * Checks if the input is an integer
	 * @param input 
	 * @return true if it is an integer
	 */
private boolean isInteger(String input){
	try {
	Integer.valueOf(input);
	} catch(NumberFormatException exeption)	{
		return false;
	}
	return true;
}

/**
 * Returns a query string that can be used if the user is searching by city name
 * @param searchPhrase
 * @return A string query
 */
private String getCityBasedQuery(String searchPhrase){
	String query = " SELECT ZipCodeData.*, LocationData.*, CrossReference.* " +
			"FROM ZipCodeData, LocationData, CrossReference " +
			"WHERE LocationData.City LIKE '%" + searchPhrase + "%' " +
			"AND CrossReference.LocationDataId = LocationData._id " +
			"AND CrossReference.ZipCodeId = ZipCodeData._id;";
	
	return query;
}

/**
 * Returns a query string that can be used if the user is searching by Zip code
 * @param searchPhrase
 * @return A string query
 */
private String getZipBasedQuery(String searchPhrase){
	String query = " SELECT ZipCodeData.*, LocationData.*, CrossReference.* " +
			"FROM ZipCodeData, LocationData, CrossReference " +
			"WHERE ZipCodeData.ZipCode LIKE '%" + searchPhrase + "%' " +
			"AND CrossReference.LocationDataId = LocationData._id " +
			"AND CrossReference.ZipCodeId = ZipCodeData._id;";
	
	return query;
}

/**
 * Takes a search phrase and a database and returns a list of objects
 * @param searchPhrase
 * @param database
 * @return A list of objects
 */
private String getCategoriesQuery(){
	String query = " SELECT category " +
			"FROM Categories;";
	return query;
}
private String getRecipesQuery(String category){
	String query = " SELECT * " +
			"FROM Recipes " +
			"WHERE category " +
			"= " +
			"(SELECT _id " +
			"FROM Categories " +
			"WHERE category " +
			"= '" + category + "');";
	return query;
}
public List<String> getCategories(SQLiteDatabase database){
	String query = getCategoriesQuery();
	Log.d("Query: ", query);
	cursor = database.rawQuery(query, null);
	return cursorToCategories(cursor);
}
public List<Recipe> getRecipies(String category, SQLiteDatabase database){
	String query = getRecipesQuery(category);
	Log.d("Query: ", query);
	cursor = database.rawQuery(query, null);
	return cursorToRecipeList(cursor);
}
//public List<BriefResult> searchByQuery(String searchPhrase, SQLiteDatabase database){
//	listResult.clear();
//
//	if(isInteger(searchPhrase))
//		query = getZipBasedQuery(searchPhrase);
//	else
//		query = getCityBasedQuery(searchPhrase);
//
//	cursor = database.rawQuery(query, null);
//	onSearchListener.setCursor(cursor);
//	listResult = cursorToList(cursor);
//	return listResult;
//}

private List<String> cursorToCategories(Cursor cursor){
	if(cursor == null || cursor.getCount() == 0)
		return null;
	
	cursor.moveToFirst();
	List<String> result = new ArrayList<String>();
	
	do
	{
		String temp = new String();
		temp = cursor.getString(0);
		Log.d("Category : ", temp);
		result.add(temp);
	}while (cursor.moveToNext());
	
	return result;
}

/**
 * It takes a cursor and converts it to a list of objects
 * @param cursor
 * @return A list of objects
 */
private List<Recipe> cursorToRecipeList(Cursor cursor){
	
	if(cursor == null || cursor.getCount() == 0)
		return null;
	
	cursor.moveToFirst();
	List<Recipe> result = new ArrayList<Recipe>();
	
	do
	{
		Recipe temp = new Recipe();
		
		temp.setID(cursor.getString(0));
		temp.setName(cursor.getString(1));
		temp.setMinutes(cursor.getString(2));
		temp.setCategory(cursor.getString(3));
		temp.setIngredients(cursor.getString(4));
		temp.setInstructions(cursor.getString(5));
		
		result.add(temp);
	}while (cursor.moveToNext());
	
	return result;
}


}
