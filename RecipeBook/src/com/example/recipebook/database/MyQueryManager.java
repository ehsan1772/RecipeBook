
package com.example.recipebook.database;

import java.util.ArrayList;
import java.util.List;

import com.example.recipebook.Recipe;
import com.example.recipebook.interfaces.QueryListener;

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
	cursor = database.rawQuery(query, null);
	return cursorToCategories(cursor);
}
public List<Recipe> getRecipies(String category, SQLiteDatabase database){
	String query = getRecipesQuery(category);
	cursor = database.rawQuery(query, null);
	return cursorToRecipeList(cursor, category);
}


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
private List<Recipe> cursorToRecipeList(Cursor cursor, String category){
	
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
		temp.setCategory(category);
		temp.setIngredients(cursor.getString(4));
		temp.setInstructions(cursor.getString(5));
		
		result.add(temp);
	}while (cursor.moveToNext());
	
	return result;
}

public void createNew(String[] inputs, SQLiteDatabase database){
	String query = getCreateNewQuery(inputs);
	database.execSQL(query);
	
}


public void deleteRecipe(String id, SQLiteDatabase database){
	String query = getDeleteSQL(id);
	database.execSQL(query);
}

private String getDeleteSQL(String id){
	
	String sql = "DELETE FROM Recipes WHERE _id = "+ id;
	return sql;
	
}
private String getCreateNewQuery(String[] inputs) {
	String query = "INSERT INTO Recipes " +
"(name, minutes, category, ingredients, instructions) VALUES ('" +
			inputs[0] + "' , " +
			inputs[1] + " , " +
			"(SELECT _id " +
			"FROM Categories " +
			"WHERE category " +
			"= '" + inputs[2] + "') , '" +
			inputs[3] + "' , '" +
			inputs[4] + "')";
	
	return query;
}

}
