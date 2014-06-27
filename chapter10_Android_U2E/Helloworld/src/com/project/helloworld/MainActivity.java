package com.project.helloworld;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;


public class MainActivity extends UnityPlayerActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// ��Unity�е��õĺ���
	protected void HelloWorld(final String title, final String content)
	{
		 runOnUiThread(new Runnable() {     
			  public void run() {
				  MakeDialog(title, content);
			  }
		  });
	}
	
	// ��ʾ�Ի���
	public void MakeDialog(String title, String content) 
	{
	        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	        
	        builder.setTitle(title)
	            .setMessage(content)
	            .setCancelable(false)
	            .setPositiveButton("OK", new DialogInterface.OnClickListener(){
	            	public void onClick(DialogInterface dialog, int which) {
	            		UnityPlayer.UnitySendMessage("AndroidManager", "AndroidCallBack", "");
	            	}
	            }
	            		);

	        builder.show();
	}

}
