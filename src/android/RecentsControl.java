package com.stokesmcnutt.cordova.recentscontrol;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import org.json.JSONException;

public class RecentsControl extends CordovaPlugin {
	
	private final String PLUGIN = "RecentsControl";

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			String colorStr = preferences.getString("RecentsBackgroundColor", "#000000");
			String desc = preferences.getString("RecentsDescription", "");
			if(!desc.isEmpty()) {
				setOptions(colorStr, desc);
			} else {
				setColor(colorStr);
			}
		}
	}
	
	@Override
	public boolean execute(final String action, final CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
		if ("setColor".equals(action)) {
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					try {
						setColor(args.getString(0));
					} catch(JSONException ignore) {
						Log.e(PLUGIN, "Called setColor without valid argument");
					}
				}
			});
		} else if("setDescription".equals(action)) {
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					try {
						setDescription(args.getString(0));
					} catch(JSONException ignore) {
						Log.e(PLUGIN, "Called setDescription without valid argument");
					}
				}
			});
		} else if("setOptions".equals(action)) {
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					try {
						setOptions(args.getString(0), args.getString(1));
					} catch(JSONException ignore) {
						Log.e(PLUGIN, "Called setOptions with one or both arguments invalid");
					}
				}
			});
		}
		return false;
	}
	
	private void setColor(final String colorStr) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			if (colorStr != null && !colorStr.isEmpty()) {
				ActivityManager activityManager = (ActivityManager) cordova.getActivity().getSystemService(Context.ACTIVITY_SERVICE);
				try {
					int color = Color.parseColor(colorStr);
					for(ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
						if(appTask.getTaskInfo().id == cordova.getActivity().getTaskId()) {
							ActivityManager.TaskDescription description = appTask.getTaskInfo().taskDescription;
							cordova.getActivity().setTaskDescription(new ActivityManager.TaskDescription(description.getLabel(), description.getIcon(), color));
						}
					}
				} catch (IllegalArgumentException ignore) {
					Log.e(PLUGIN, "Invalid color argument, use a hex string e.g. #00FF00");
				}
			}
		}
	}
	
	private void setDescription(final String desc) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			if (desc != null && !desc.isEmpty()) {
				ActivityManager activityManager = (ActivityManager) cordova.getActivity().getSystemService(Context.ACTIVITY_SERVICE);
				try {
					for(ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
						if(appTask.getTaskInfo().id == cordova.getActivity().getTaskId()) {
							ActivityManager.TaskDescription description = appTask.getTaskInfo().taskDescription;
							cordova.getActivity().setTaskDescription(new ActivityManager.TaskDescription(desc, description.getIcon(), description.getPrimaryColor()));
						}
					}
				} catch (IllegalArgumentException ignore) {
					Log.e(PLUGIN, "Invalid description argument, must be a non-empty string");
				}
			}
		}
	}
	
	private void setOptions(final String colorStr, final String desc) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			if ((colorStr != null && !colorStr.isEmpty()) && (desc != null && !desc.isEmpty())) {
				ActivityManager activityManager = (ActivityManager) cordova.getActivity().getSystemService(Context.ACTIVITY_SERVICE);
				try {
					int color = Color.parseColor(colorStr);
					for(ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
						if(appTask.getTaskInfo().id == cordova.getActivity().getTaskId()) {
							ActivityManager.TaskDescription description = appTask.getTaskInfo().taskDescription;
							cordova.getActivity().setTaskDescription(new ActivityManager.TaskDescription(desc, description.getIcon(), color));
						}
					}
				} catch (IllegalArgumentException ignore) {
					Log.e(PLUGIN, "Invalid color or description argument, use a hex string e.g. #00FF00 for color and a non-empty string for description");
				}
			}
		}
	}
}