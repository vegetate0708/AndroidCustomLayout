package com.zxf.androidcustomlayout.Design.Demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zxf.androidcustomlayout.Design.Demo.Behavior.BehaviorActivity1;
import com.zxf.androidcustomlayout.Design.Demo.CoodinatorLayout.zhihuDemo.ZhihuActivity;
import com.zxf.androidcustomlayout.R;

/**
 * Created by Administrator on 2017/5/18.
 */
public class BehaviorAcitvityMain extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behaviormain);
        findViewById(R.id.bt_behavior1).setOnClickListener(this);
        findViewById(R.id.bt_behavior_zhihu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_behavior1:
                Intent behavior1= new Intent(BehaviorAcitvityMain.this, BehaviorActivity1.class);
                startActivity(behavior1);
                break;
            case R.id.bt_behavior_zhihu:
                Intent zhihu= new Intent(BehaviorAcitvityMain.this, ZhihuActivity.class);
                startActivity(zhihu);
                break;
        }
    }
}
