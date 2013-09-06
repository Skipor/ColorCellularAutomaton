package ru.skipor.test2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import java.util.Random;


public class MainActivity extends Activity {


    static class myView extends View {
        final static int COLORS_NUM = 16; //16 is only possible
        final static int HEIGHT = 640;
        final static int WIDTH = 480;
        State current;
        State next;

        final static Paint[] paints = new Paint[COLORS_NUM];
        final static Random random = new Random();



        static {
            for (int i = 0; i < COLORS_NUM; i++) {
                paints[i] = new Paint();
                paints[i].setARGB(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

            }
        }

        class State {
            int colors[][];

            State() {
                colors = new int[myView.HEIGHT][myView.WIDTH];
            }

            public void setRandom() {
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        colors[i][j] = random.nextInt(COLORS_NUM);
                    }
                }
            }
        }

        public myView(Context context) {
            super(context);
            current = new State();
            current = new State();
        }

        protected void nextState() {


        }


        @Override
        public void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setARGB(255, 0, 0, 0);
            canvas.drawRect(10, 10, 90, 90, paint);
            invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new myView(this));
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

}
