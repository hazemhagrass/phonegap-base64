/**
 * 
 * Phonegap Email composer plugin for Android with multiple attachments handling
 * 
 * Version 1.0
 * 
 * Guido Sabatini 2012
 *
 */

package com.badrit.Base64;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

public class Base64Plugin extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("encodeFile".equals(action)) {
			
			try {
				JSONObject parameters = args.getJSONObject(0);
				if (parameters != null) {
					encodeFile(parameters);
				}
			} catch (Exception e) {

			}
			callbackContext.success();
			return true;
		}
		return false;  // Returning false results in a "MethodNotFound" error.
	}

	private void encodeFile(JSONObject parameters) {
		
	}
	

}
