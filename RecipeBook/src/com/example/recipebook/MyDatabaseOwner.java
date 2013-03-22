package com.example.recipebook;

/**
 * This interface is implemented by the main activity and the methods are used the first time 
 * that the app is launched to prepare the UI during copying the database
 * @author Ehsan Barekati
 *
 */
public interface MyDatabaseOwner {
	void datatabaseInitializationStart();
	void datatabaseInitializationDone();
}
