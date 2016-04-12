package com.example.intentservice;

import de.greenrobot.event.EventBus;
import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class IntentServiceDemo extends IntentService {  

	public IntentServiceDemo() {  
		//必须实现父类的构造方法  
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
		//Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务  
		String action = intent.getExtras().getString("param");  

		//模拟耗时操作
		try {  
			Thread.sleep(2000);  
		} catch (InterruptedException e) {  
			e.printStackTrace();  
		}  
		
		//根据任务的参数，执行对应的任务，所以对于任务量比较大而且比较多，又不需要与用户交互的，使用intentService
		if (action.equals("oper1")) {
			Log.d("IntentServiceDemo","Operation1");
			EventBus.getDefault().post("aaa");//任务完成 发送消息提示ui更新
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