package com.example.lehiteixeira.appedu.Quiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lehiteixeira.appedu.MainHome.ListCardMainAdapter;
import com.example.lehiteixeira.appedu.R;

public class QuizActivity extends AppCompatActivity {

    private TextView textAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setImageBitmap(ListCardMainAdapter.b);

        //textAnim =  (TextView) findViewById(R.id.txtNome);

        img2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (textAnim.getVisibility() != View.VISIBLE) {

                // previously invisible view
                // get the center for the clipping circle
                int cx = (textAnim.getLeft() + textAnim.getRight()) / 2;
                int cy = (textAnim.getTop() + textAnim.getBottom()) / 2;
                // get the final radius for the clipping circle
                int finalRadius = Math.max(textAnim.getWidth(), textAnim.getHeight());
                // create the animator for this view (the start radius is zero)
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(textAnim, cx, cy, 0, finalRadius);
                // make the view visible and start the animation
                anim.start();
              //      textAnim.setVisibility(View.VISIBLE);
             }else {
                // get the center for the clipping circle
                int cx = (textAnim.getLeft() + textAnim.getRight()) / 2;
                int cy = (textAnim.getTop() + textAnim.getBottom()) / 2;
                // get the initial radius for the clipping circle
                int initialRadius = textAnim.getWidth();
                 // create the animation (the final radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(textAnim, cx, cy, initialRadius, 0);
                // make the view invisible when the animation is done
                anim.addListener(new AnimatorListenerAdapter() {
                @Override
                 public void onAnimationEnd(Animator animation) {
                           super.onAnimationEnd(animation);
                 //        textAnim.setVisibility(View.INVISIBLE);
                   }
                  });
                    // start the animation
                    anim.start();

                }
            }
        });
    }
}
