package com.carrey.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 类描述：
 * 创建人：carrey
 * 创建时间：2015/11/17 10:37
 */

public class PropertyAnimationAct extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_list);
        findViewById(R.id.frame).setOnClickListener(this);
        findViewById(R.id.frame1).setOnClickListener(this);
        findViewById(R.id.controller).setOnClickListener(this);
        findViewById(R.id.parabola).setOnClickListener(this);
        findViewById(R.id.controllerset).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PropertyDetalAct.class);
        switch (v.getId()) {
//            case R.id.alphaxml:
//                intent.putExtra(AnimationDetal.TYPE, 1);
//                break;
//            case R.id.alpha:
//                intent.putExtra(AnimationDetal.TYPE, 2);
//                break;
//            case R.id.scalexml:
//                intent.putExtra(AnimationDetal.TYPE, 3);
//                break;
//            case R.id.scale:
//                intent.putExtra(AnimationDetal.TYPE, 4);
//                break;
//            case R.id.translatexml:
//                intent.putExtra(AnimationDetal.TYPE, 5);
//                break;
//            case R.id.translate:
//                intent.putExtra(AnimationDetal.TYPE, 6);
//                break;
            case R.id.parabola:
                intent.putExtra(AnimationDetal.TYPE, 7);
                break;
            case R.id.frame1:
                intent.putExtra(AnimationDetal.TYPE, 8);
                break;
            case R.id.frame:
                intent.putExtra(AnimationDetal.TYPE,9);
                break;
            case R.id.controller:
                intent.putExtra(AnimationDetal.TYPE,10);
                break;  case R.id.controllerset:
                intent.putExtra(AnimationDetal.TYPE,11);
                break;
        }
        startActivity(intent);

    }
}
