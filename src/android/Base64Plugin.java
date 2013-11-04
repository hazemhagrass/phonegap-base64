/**
 * 
 * Phonegap Base64 plugin
 * 
 * Version 1.0
 * 
 * Hazem Hagrass 2013
 *
 */

package com.badrit.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Html;
import android.util.Base64;

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
					String base64String = encodeFile(parameters.getString("filePath"));
					callbackContext.success(base64String);
				}
			} catch (Exception e) {

			}
			
			return true;
		}
		return false; 
	}

	private String encodeFile(String filePath) {
		String imgStr = "";
		filePath = filePath.replaceAll("file://", "");
		File imageFile = new File(filePath);
		if(!imageFile.exists())
			return imgStr;
		Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
		byte[] image = stream.toByteArray();
		imgStr = Base64.encodeToString(image, 0);
		
		return imgStr;
	}
	

}
