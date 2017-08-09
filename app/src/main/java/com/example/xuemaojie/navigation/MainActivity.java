package com.example.xuemaojie.navigation;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.xuemaojie.navigation.MyFragment;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //UI Object
    private TextView txt_topbar;
    private TextView txt_index;
    private TextView txt_release;
    private TextView txt_change;
    private TextView txt_setting;


    public FrameLayout ly_content;

    //Fragment Object
    private MyFragment fg1,fg2,fg3,fg4;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindViews();
        txt_index.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        txt_index = (TextView) findViewById(R.id.txt_index);
        txt_release = (TextView) findViewById(R.id.txt_release);

        txt_change = (TextView) findViewById(R.id.txt_change);
        txt_setting = (TextView) findViewById(R.id.txt_setting);

        //ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_index.setOnClickListener(this);
        txt_release.setOnClickListener(this);

        txt_change.setOnClickListener(this);
        txt_setting.setOnClickListener(this);

    }

    //重置所有文本的选中状态
    private void setSelected(){
        txt_index.setSelected(false);
        txt_release.setSelected(false);

        txt_change.setSelected(false);
        txt_setting.setSelected(false);

    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);

    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_index:
                setSelected();
                txt_index.setSelected(true);
                if(fg1 == null){
                    fg1 = new MyFragment("第一个Fragment");
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;

            case R.id.txt_release:
                setSelected();
                txt_release.setSelected(true);
                if(fg2 == null){
                    fg2 = new MyFragment("第二个Fragment");
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;

            case R.id.txt_post:
                setSelected();
                txt_release.setSelected(true);
                if(fg3 == null){
                    fg3 = new MyFragment("第三个Fragment");
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;

            case R.id.txt_change:
                setSelected();
                txt_change.setSelected(true);
                if(fg4 == null){
                    fg4 = new MyFragment("第四个Fragment");
                    fTransaction.add(R.id.ly_content,fg4);
                }else{
                    fTransaction.show(fg4);
                }
                break;


        }
        fTransaction.commit();
    }
}
