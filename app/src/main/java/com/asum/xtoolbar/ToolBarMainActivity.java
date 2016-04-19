package com.asum.xtoolbar;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.asum.xlayoutparams.utils.DensityUtils;
import com.asum.xlayoutparams.utils.XPxArea;
import com.asum.xtoolbar.utils.XTopBar;

public class ToolBarMainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_main);

        Point point = DensityUtils.getScreenPx(getApplicationContext());

        XTopBar topBar = (XTopBar) findViewById(R.id.topbar);
        topBar.setBackgroundColor(Color.CYAN);
        topBar.initialize(0, 300, XPxArea.MATCH, point.y * 0.07);

        topBar.addLeftButton(R.drawable.buttonstyle, "名字", XPxArea.WRAP, point.y * 0.03, 1);
        topBar.addLeftButton(R.drawable.buttonstyle_return, point.y * 0.05, point.y * 0.05, 2);
        topBar.addLeftTextButton(R.drawable.buttonstyle_text, "名字", XPxArea.WRAP, point.y * 0.05, 3);

        topBar.addRightButton(R.drawable.buttonstyle, "名字", XPxArea.WRAP, point.y * 0.05, 4);
        topBar.addRightButton(R.drawable.buttonstyle_return, point.y * 0.05, point.y * 0.05, 5);
        topBar.addRightTextButton(R.drawable.buttonstyle_text, "名字", XPxArea.WRAP, point.y * 0.05, 6);

        topBar.removeByClickFlag(5);

        topBar.setCallBack(new XTopBar.XTopBarCallBack() {
            public void onClick(int flag) {
                Log.i("XJW", flag + "");
            }
        });
    }
}
