package com.carrey.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 类描述：
 * 创建人：carrey
 * 创建时间：2015/11/17 10:37
 */

public class PropertyDetalAct extends AppCompatActivity implements View.OnClickListener {
    public static String TYPE = "type";
    private int type;

    private ImageView imageView, ball;
    private int mScreenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_detal);
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
                verticalRun1(imageView);
                break;
            case 2:
                paowuxian(imageView);
                break;

            case 7:   //抛物线
                parabolaAnim(imageView);
                break;
            case 8:      //集合
//                rotateyAnimRun1(imageView);
                propertyValuesHolder(imageView);
                break;
            case 9:
                rotateyAnimRun(imageView);
                break;
            case 10:
                fadeOut();
//                verticalRun1(imageView);
                break;
            case 11:
                playWithAfter(imageView );
                break;
        }
    }
    private void playWithAfter(ImageView imageView){
        float cx = ball.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(ball, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(ball, "scaleY",
                1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(ball,
                "x",  cx ,  0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(ball,
                "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }
    private void fadeOut() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ball, "alpha", 0.5f);

//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                ViewGroup parent = (ViewGroup) ball.getParent();
//                if (parent != null) {
//                    parent.removeView(ball);
//                }
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                ViewGroup parent = (ViewGroup) ball.getParent();
                if (parent != null) {
                    parent.removeView(ball);
                    Toast.makeText(parent.getContext(), "delete", Toast.LENGTH_SHORT).show();
                }
            }
        });

        objectAnimator.start();


    }


    /**
     * 自由落体
     *
     * @param view
     */
    public void verticalRun1(View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight
                - ball.getHeight());
        animator.setTarget(ball);
        animator.setDuration(1000).start();
//      animator.setInterpolator(value)
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ball.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }

    public void verticalRun(View view) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight
                - ball.getHeight());
        animator.setTarget(ball);
        animator.setDuration(1000).start();
    }

    /**
     * 抛物线
     *
     * @param view
     */
    public void paowuxian(View view) {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue) {
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                ball.setX(point.x);
                ball.setY(point.y);

            }
        });
    }

    public void propertyValuesHolder(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(1000).start();
    }

    private void parabolaAnim(final View view) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "xxx", 0.0f, 1.0f).setDuration(15000);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                view.setTranslationX(value * 100);
                view.setTranslationY(value * 200);
            }
        });
    }

    public void rotateyAnimRun(View view) {
        ObjectAnimator
                .ofFloat(view, "rotationX", 0.0F, 360.0F)//
                .setDuration(500)//
                .start();
    }

    public void rotateyAnimRun1(final View view) {
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(view, "zhy", 1.0F, 0.0F)//
                .setDuration(1500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);
            }
        });
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
