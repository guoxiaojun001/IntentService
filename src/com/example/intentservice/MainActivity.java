package com.example.intentservice;


import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnStartService,btnStopService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStartService = (Button) findViewById(R.id.btnStartService);
		btnStopService = (Button) findViewById(R.id.btnStopService);
		
		EventBus.getDefault().register(this);

		startService();
	}

	private void startService() {
		//����������Σ�ÿ����һ�Σ��ͻ��½�һ��work thread����IntentService��ʵ��ʼ��ֻ��һ��  
		//Operation 1  
		Intent startServiceIntent = new Intent("com.test.intentservice");  
		startServiceIntent.setPackage("com.example.intentservice");
		Bundle bundle = new Bundle();  
		bundle.putString("param", "oper1");  
		startServiceIntent.putExtras(bundle);  
		startService(startServiceIntent);  

		//Operation 2  
		Intent startServiceIntent2 = new Intent("com.test.intentservice");  
		startServiceIntent2.setPackage("com.example.intentservice");
		Bundle bundle2 = new Bundle();  
		bundle2.putString("param", "oper2");  
		startServiceIntent2.putExtras(bundle2);  
		startService(startServiceIntent2);
	}
	
	
	public void onEventMainThread(String event) {
		//������Ϣ ��ˢ��ui
		if("aaa".equals(event)){
			btnStartService.setText(event);
		}else if("bbb".equals(event)) {
			btnStopService.setText(event);
		}
	}
}
