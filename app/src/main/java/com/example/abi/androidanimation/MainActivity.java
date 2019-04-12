package com.example.abi.androidanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logo1, logo2;
    private TextView txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo1 = findViewById(R.id.first_img);
        logo2 = findViewById(R.id.second_img);
        txvShared = findViewById(R.id.animation_text);

        setupWindowAnimation();
    }

    private void setupWindowAnimation() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right-to-left locale
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition); // when MainActivity Re-enters the screen
        getWindow().setExitTransition(slideTransition);    // when MainActivity Exits the screen

        // For Overlap of Re-entering Activity- MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
    }

    public void checkRippleAnimation(View view){
        Intent intent = new Intent(MainActivity.this, RippleActivity.class);
        startActivity(intent);
    }

    public void sharedElementTransition(View view){
        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View, String>(logo1, "logo_shared");
        pair[1] = new Pair<View, String>(logo2,"smartherd_shared");
        pair[2] = new Pair<View, String>(txvShared, "profile_pic_shared");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent intent = new Intent(MainActivity.this, ActivitySharedElement.class);
        startActivity(intent, options.toBundle());
    }

    public void explodeTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        intent.putExtra(Constants.KEY_TITLE, "Explode By Java");
        startActivity(intent, options.toBundle());
    }

    public void explodeTransitionByXml(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        intent.putExtra(Constants.KEY_TITLE, "Explode By Xml");
        startActivity(intent, options.toBundle());
    }

    public void slideTransitionByCode(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
        intent.putExtra(Constants.KEY_TITLE, "Slide By Java");
        startActivity(intent, options.toBundle());
    }

    public void slideTransitionByXml(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        intent.putExtra(Constants.KEY_TITLE, "Slide By Xml");
        startActivity(intent, options.toBundle());
    }

    public void fadeTransitionByCode(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
        intent.putExtra(Constants.KEY_TITLE, "Fade By Java");
        startActivity(intent, options.toBundle());
    }

    public void fadeTransitionByXml(View view) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(MainActivity.this, TransitionActivity.class);
        intent.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
        intent.putExtra(Constants.KEY_TITLE, "Fade By Xml");
        startActivity(intent, options.toBundle());
    }
}
