package media.sigma.getit.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by avikal on 4/18/2016.
 */
public class SharedPrefs
{
    public static final String PREFERENCE_NAME = "GetIt";
    public static String value = null;
    public static int intValue;
    public static boolean boolValue = false;

    public static String getDefaultSharedPrefes(Context context,String key)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if(prefs!=null && prefs.contains(key))
        {
            value = prefs.getString(key,"null");
        }
        return value;
    }
    public static int getDefaultIntegerSharedPrefes(Context context, String key)
    {
        SharedPreferences prefes = PreferenceManager.getDefaultSharedPreferences(context);
        if(prefes!=null && prefes.contains(key))
        {
            intValue = prefes.getInt(key, -1);
        }
        return intValue;
    }
    public static boolean getDefaultBooleanSharedPrefes(Context context,String key)
    {
        SharedPreferences prefes = PreferenceManager.getDefaultSharedPreferences(context);
        if (prefes!=null && prefes.contains(key))
        {
            boolValue = prefes.getBoolean(key, false);
        }
        return boolValue;
    }

    public static String getValue(Context context,String key)
    {
        String value = getDefaultSharedPrefes(context, key);
        return value;
    }
    public static int getIntegerValue(Context context, String key)
    {
        int value = getDefaultIntegerSharedPrefes(context, key);
        return value;
    }
    public static boolean getBooleanValue(Context context, String key)
    {
        boolean value = getDefaultBooleanSharedPrefes(context, key);
        return value;
    }

    public static void setDefaultSharedPrefs(Context context, String key, String value)
    {
        SharedPreferences prefes = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefes.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void setDefaultIntegerSharedPrefs(Context context, String key, int value)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public static void setDefaultBooleanSharedPrefes(Context context, String key, boolean value)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }
    public static void deletePreferanceData(Activity activity)
    {
        SharedPreferences preferences = activity.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        preferences.edit().clear().commit();
    }
}
