package com.example.propertyanimationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        /**
         * 代码实现属性动画
         */
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
            }
        });
        /**
         * XML文件实现属性动画
         */
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_file);
//        animator.setTarget(textView);
//        animator.start();
        /**
         * 利用ViewPropertyAnimator 实现简单属性动画
         */
//        textView.animate().alpha(0).setDuration(5000);
    }
}