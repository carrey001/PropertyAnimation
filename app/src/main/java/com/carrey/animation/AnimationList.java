package com.carrey.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 类描述：
 * 创建人：carrey
 * 创建时间：2015/11/17 10:37
 */

public class AnimationList extends AppCompatActivity implements View.OnClickListener {


    // Content View Elements

    private Button mAlphaxml;
    private Button mAlpha;
    private Button mScalexml;
    private Button mScale;
    private Button mTranslatexml;
    private Button mTranslate;
    private Button mRotatexml;
    private Button mRotate;

    // End Of Content View Elements

    private void bindViews() {

        mAlphaxml = (Button) findViewById(R.id.alphaxml);
        mAlpha = (Button) findViewById(R.id.alpha);
        mScalexml = (Button) findViewById(R.id.scalexml);
        mScale = (Button) findViewById(R.id.scale);
        mTranslatexml = (Button) findViewById(R.id.translatexml);
        mTranslate = (Button) findViewById(R.id.translate);
        mRotatexml = (Button) findViewById(R.id.rotatexml);
        mRotate = (Button) findViewById(R.id.rotate);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        bindViews();
        setEvent();
    }

    private void setEvent() {
        mAlpha.setOnClickListener(this);
        mAlphaxml.setOnClickListener(this);
        mRotate.setOnClickListener(this);
        mRotatexml.setOnClickListener(this);
        mScale.setOnClickListener(this);
        mScalexml.setOnClickListener(this);
        mTranslate.setOnClickListener(this);
        mTranslatexml.setOnClickListener(this);
        findViewById(R.id.frame).setOnClickListener(this);
        findViewById(R.id.controller).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AnimationDetal.class);
        switch (v.getId()) {
            case R.id.alphaxml:
                intent.putExtra(AnimationDetal.TYPE, 1);
                break;
            case R.id.alpha:
                intent.putExtra(AnimationDetal.TYPE, 2);
                break;
            case R.id.scalexml:
                intent.putExtra(AnimationDetal.TYPE, 3);
                break;
            case R.id.scale:
                intent.putExtra(AnimationDetal.TYPE, 4);
                break;
            case R.id.translatexml:
                intent.putExtra(AnimationDetal.TYPE, 5);
                break;
            case R.id.translate:
                intent.putExtra(AnimationDetal.TYPE, 6);
                break;
            case R.id.rotatexml:
                intent.putExtra(AnimationDetal.TYPE, 7);
                break;
            case R.id.rotate:
                intent.putExtra(AnimationDetal.TYPE, 8);
                break;
            case R.id.frame:
                intent.putExtra(AnimationDetal.TYPE,9);
                break;
            case R.id.controller:
                intent.putExtra(AnimationDetal.TYPE,10);
                break;
        }
        startActivity(intent);

    }
}
