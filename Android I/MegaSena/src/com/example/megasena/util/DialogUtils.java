package com.example.megasena.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogUtils {

	public static void showCustomDialog(Context context, 
			String title, 
			String message, 
			String positiveLabel, 
			DialogInterface.OnClickListener positiveListener,
			String negativeLabel, 
			DialogInterface.OnClickListener negativeListener) {
		
		new AlertDialog.Builder(context)
	    .setTitle(title)
	    .setMessage(message)
	    .setPositiveButton(positiveLabel, positiveListener)
	    .setNegativeButton(negativeLabel, negativeListener)
	    .show();
	}

	public static void showCustomDialog(Context context, 
			String title, 
			String message,
			String label, 
			DialogInterface.OnClickListener listener) {
		
		new AlertDialog.Builder(context)
	    .setTitle(title)
	    .setMessage(message)
	    .setPositiveButton(label, listener)
	    .show();
	}
	
	public static void showMessageDialog(Context context, 
			String title, 
			String message) {
		
		new AlertDialog.Builder(context)
	    .setTitle(title)
	    .setMessage(message)
	    .setPositiveButton("OK", null)
	    .show();
	}

}