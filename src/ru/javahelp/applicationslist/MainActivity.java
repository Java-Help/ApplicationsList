package ru.javahelp.applicationslist;

import java.util.List;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView appList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		appList = (ListView) findViewById(R.id.appList);

		PackageManager pm = getPackageManager();
		List<ApplicationInfo> packages = pm
				.getInstalledApplications(PackageManager.GET_META_DATA);

		AppListAdapter appListAdapter = new AppListAdapter(this, pm, packages);
		appList.setAdapter(appListAdapter);
	}

	
}
