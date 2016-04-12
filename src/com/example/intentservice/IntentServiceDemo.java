package com.example.intentservice;

import de.greenrobot.event.EventBus;
import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class IntentServiceDemo extends IntentService {  

	public IntentServiceDemo() {  
		//����ʵ�ָ���Ĺ��췽��  
		super("IntentServiceDemo");  
	}  

	@Override  
	public IBinder onBind(Intent intent) {  
		Log.d("IntentServiceDemo","onBind");  
		return super.onBind(intent);  
	}  


	@Override  
	public void onCreate() {  
		Log.d("IntentServiceDemo","onCreate");  
		super.onCreate();  
	}  

	@Override  
	public void onStart(Intent intent, int startId) {  
		Log.d("IntentServiceDemo","onStart");  
		super.onStart(intent, startId);  
	}  


	@Override  
	public int onStartCommand(Intent intent, int flags, int startId) {  
		Log.d("IntentServiceDemo","onStartCommand");  
		return super.onStartCommand(intent, flags, startId);  
	}  


	@Override  
	public void setIntentRedelivery(boolean enabled) {  
		super.setIntentRedelivery(enabled);  
		Log.d("IntentServiceDemo", "setIntentRedelivery");  
	}  

	@Override  
	protected void onHandleIntent(Intent intent) {  
		//Intent�Ǵ�Activity�������ģ�Я��ʶ����������ݲ�����ִͬ�в�ͬ������  
		String action = intent.getExtras().getString("param");  

		//ģ���ʱ����
		try {  
			Thread.sleep(2000);  
		} catch (InterruptedException e) {  
			e.printStackTrace();  
		}  
		
		//��������Ĳ�����ִ�ж�Ӧ���������Զ����������Ƚϴ���ұȽ϶࣬�ֲ���Ҫ���û������ģ�ʹ��intentService
		if (action.equals("oper1")) {
			Log.d("IntentServiceDemo","Operation1");
			EventBus.getDefault().post("aaa");//������� ������Ϣ��ʾui����
		}else if (action.equals("oper2")) {  
			Log.d("IntentServiceDemo","Operation2");
			EventBus.getDefault().post("bbb");
		}  
	}  

	@Override  
	public void onDestroy() {  
		Log.d("IntentServiceDemo","onDestroy");  
		super.onDestroy();  
	}  

}