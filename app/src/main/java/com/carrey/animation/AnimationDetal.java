package com.carrey.animation;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 类描述：
 * 创建人：carrey
 * 创建时间：2015/11/17 10:37
 */

public class AnimationDetal extends AppCompatActivity {
    public static String TYPE = "type";
    private ImageView view;
    private int type;
    private ListView listView;

    private int[] data = {1, 2, 3, 4, 5, 6, 7, 8};

    //在代码中定义 动画实例对象
    private Animation myAnimation_Alpha;
    private Animation myAnimation_Scale;
    private Animation myAnimation_Translate;
    private Animation myAnimation_Rotate;

    private AnimationDrawable frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detal);
        view = (ImageView) findViewById(R.id.image);
        type = getIntent().getIntExtra(TYPE, 1);

        //根据各自的构造方法来初始化一个实例对象
        myAnimation_Alpha = new AlphaAnimation(0.1f, 1.0f);

        myAnimation_Scale = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        myAnimation_Translate = new TranslateAnimation(30.0f, -80.0f, 30.0f, 300.0f);

        myAnimation_Rotate = new RotateAnimation(0.0f, +350.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return data.length;
            }

            @Override
            public Object getItem(int position) {
                return data[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = new TextView(getBaseContext());
                }
                ((TextView) convertView).setTextColor(Color.BLACK);
                ((TextView) convertView).setText(getItem(position).toString());
                return convertView;
            }
        });




        startAnimation(type);
    }

    private void startAnimation(int type) {
        switch (type) {
            case 1:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
                break;
            case 2:
                myAnimation_Alpha.setDuration(1000);
                view.startAnimation(myAnimation_Alpha);
                break;
            case 3:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
                break;
            case 4:
                myAnimation_Scale.setDuration(1000);
                view.startAnimation(myAnimation_Scale);
                break;
            case 5:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
                break;
            case 6:
                myAnimation_Translate.setDuration(1000);
                view.startAnimation(myAnimation_Translate);
                break;
            case 7:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
                break;
            case 8:
                myAnimation_Rotate.setDuration(1000);
                view.startAnimation(myAnimation_Rotate);
                break;
            case 9:
                view.setImageBitmap(null);
                view.setBackgroundResource(R.drawable.frame);
                frame = (AnimationDrawable) view.getBackground();
                frame.start();
                break;

            case 10:
//                Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim_layout);
//                LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation);
//                layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
//                layoutAnimationController.setDelay(0.5f);
//                listView.setLayoutAnimation(layoutAnimationController);

                listView.setVisibility(View.VISIBLE);
                view.setVisibility(View.GONE);
                break;
        }
    }
}
