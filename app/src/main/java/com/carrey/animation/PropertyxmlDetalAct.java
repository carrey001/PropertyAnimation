package com.carrey.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

/**
 * 类描述：
 * 创建人：carrey
 * 创建时间：2015/11/17 10:37
 */

public class PropertyxmlDetalAct extends AppCompatActivity implements View.OnClickListener {
    public static String TYPE = "type";
    private int type;

    private ImageView imageView, ball;
    private int mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_xml_detal);
        type = getIntent().getIntExtra(TYPE, 0);
        imageView = (ImageView) findViewById(R.id.image);
        ball = (ImageView) findViewById(R.id.ball);
        setevent();
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenHeight = metric.heightPixels;
        imageView.setOnClickListener(this);
//        startAnimation(type);
    }

    private void setevent() {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    private void startAnimation(int type) {
        switch (type) {
            case 1:
                break;
            case 2:
                break;

            case 3:   //scale
                xmlScale(imageView);
                break;
            case 7:   //抛物线
                break;
            case 8:      //集合
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
        }
    }

    /*LayoutTransition.APPEARING 当一个View在ViewGroup中出现时，对此View设置的动画
LayoutTransition.CHANGE_APPEARING 当一个View在ViewGroup中出现时，对此View对其他View位置造成影响，对其他View设置的动画
LayoutTransition.DISAPPEARING  当一个View在ViewGroup中消失时，对此View设置的动画
LayoutTransition.CHANGE_DISAPPEARING 当一个View在ViewGroup中消失时，对此View对其他View位置造成影响，对其他View设置的动画
LayoutTransition.CHANGE 不是由于View出现或消失造成对其他View位置造成影响，然后对其他View设置的动画。*/
    private void layoutTranslate() {
        LayoutTransition transition = new LayoutTransition();
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING,
                transition.getAnimator(LayoutTransition.CHANGE_APPEARING));
        transition.setAnimator(LayoutTransition.APPEARING,
                null);
        transition.setAnimator(LayoutTransition.DISAPPEARING,
                null);
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,
                null);
//        imageView.setLayoutTransition(transition);
    }

    private void xmlScale(ImageView imageView) {
        // 加载动画
        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.obj_scale);
        imageView.setPivotX(0);      /*默认中心缩放，和中间对称线为反转线，所以我决定这个横向，纵向缩小以左上角为中心点*/
        imageView.setPivotY(0);
        imageView.invalidate();
        anim.setTarget(imageView);
        anim.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startAnimation(1);
                break;
            case R.id.btn2:
                startAnimation(2);
                break;
            default:
                startAnimation(type);
                break;
        }
    }
}
