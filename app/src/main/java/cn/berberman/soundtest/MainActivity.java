package cn.berberman.soundtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	Button[] buttons;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttons = new Button[6];
		buttons[0] = (Button) findViewById(R.id.a);
		buttons[1] = (Button) findViewById(R.id.b);
		buttons[2] = (Button) findViewById(R.id.c);
		buttons[3] = (Button) findViewById(R.id.d);
		buttons[4] = (Button) findViewById(R.id.e);
		buttons[5] = (Button) findViewById(R.id.f);
		for (Button button : buttons) button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.a:
				SoundsPlayer.Get(this).Play(Sounds.比赛开始, 1);
				break;
			case R.id.b:
				SoundsPlayer.Get(this).Play(Sounds.自动结束, 1);
				break;
			case R.id.c:
				SoundsPlayer.Get(this).Play(Sounds.比赛结束, 1);
				break;
			case R.id.d:
				SoundsPlayer.Get(this).Play(Sounds.口哨, 1);
				break;
			case R.id.e:
				SoundsPlayer.Get(this).Play(Sounds.火警, 1);
				break;
			case R.id.f:
				SoundsPlayer.Get(this).Play(Sounds.雾炮, 1);
				break;
			default:
				break;
		}
	}
}
