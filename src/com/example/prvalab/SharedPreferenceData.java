package com.example.prvalab;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceData {

	private static SharedPreferenceData datum;
	private SharedPreferences preference;
		
	private static final String P_name = "data";
	private static final String time = "last_refresh";
	
	public static synchronized SharedPreferenceData GetInstance()
	{
		if(datum == null)
		{
			datum = new SharedPreferenceData();
		}
		return datum;
	}
	public void init(Context c)
	{
		this.preference = c.getSharedPreferences(P_name, Context.MODE_PRIVATE);
	}
	
	public Long getTime()
	{
		return preference.getLong(time,-1);
	}
	public void setTime(Long l)
	{
		SharedPreferences.Editor e = preference.edit();
		e.putLong(time,l);
		e.commit();
	}
}
