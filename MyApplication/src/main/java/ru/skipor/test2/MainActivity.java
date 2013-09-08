package ru.skipor.test2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import java.util.Random;


public class MainActivity extends Activity {


    static class myView extends View {
        final static int COLORS_NUM = 16; //16 is only possible
        final static int HEIGHT = 320;
        final static int WIDTH = 240;
        final static int RECT_HEIGHT = 3; //pixel
        final static int RECT_WIDTH = 3;

        final static Rect[][] rectangles = new Rect[HEIGHT][WIDTH];

        final static Paint[] paints = new Paint[COLORS_NUM];
        final static Random random = new Random();
        State current;
        State next;

        ///
        boolean firstDraw = true;
        int count = 0;
        ///


        static {
            for (int i = 0; i < COLORS_NUM; i++) {
                paints[i] = new Paint();
                paints[i].setARGB(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    rectangles[i][j] = new Rect(j * RECT_WIDTH, i * RECT_HEIGHT, (j + 1) * (RECT_WIDTH), (i + 1) * (RECT_HEIGHT ));
                }
            }


        }

        class State {
            public int colors[][];

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
            current.setRandom();
            next = new State();

        }




        @Override
        public void onDraw(Canvas canvas) {
//            if (firstDraw){
//                firstDraw = false;
            current.setRandom();
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        canvas.drawRect(rectangles[i][j], paints[current.colors[i][j]]);
                    }
                }
//            }

////
////            while (count < 1) {
////                ++count;
//
//
//            State swapState;
//            int nextColor;
//            boolean changeColor;
//                for (int i = 1; i < HEIGHT - 1; i++) {// most part change
//                    for (int j = 1; j < WIDTH - 1; j++) {
//                        changeColor = false;
//                        nextColor = ((current.colors[i][j] + 1) & 15);
//                        changeColor |= (current.colors[i - 1][j - 1] == nextColor);
//                        changeColor |= (current.colors[i - 1][j] == nextColor);
//                        changeColor |= (current.colors[i - 1][j + 1] == nextColor);
//                        changeColor |= (current.colors[i][j - 1] == nextColor);
//                        changeColor |= (current.colors[i][j + 1] == nextColor);
//                        changeColor |= (current.colors[i + 1][j - 1] == nextColor);
//                        changeColor |= (current.colors[i + 1][j] == nextColor);
//                        changeColor |= (current.colors[i + 1][j + 1] == nextColor);
////                        next.colors[i][j] = changeColor ? nextColor : current.colors[i][j];
//                        if (changeColor) {
//                            canvas.drawRect(rectangles[i][j], paints[nextColor]);
//                            next.colors[i][j] = nextColor;
//                        } else {
//                            next.colors[i][j] = current.colors[i][j];
//                        }
//
//                    }
//                }
////                int j = 0;
////                for (int i = 1; i < HEIGHT - 1; i++) {
////                    changeColor = false;
////                    nextColor = ((current.colors[i][j] + 1) & 15);
////                    changeColor |= (current.colors[i - 1][WIDTH - 1] == nextColor);
////                    changeColor |= (current.colors[i - 1][j] == nextColor);
////                    changeColor |= (current.colors[i - 1][j + 1] == nextColor);
////                    changeColor |= (current.colors[i][WIDTH - 1] == nextColor);
////                    changeColor |= (current.colors[i][j + 1] == nextColor);
////                    changeColor |= (current.colors[i + 1][WIDTH - 1] == nextColor);
////                    changeColor |= (current.colors[i + 1][j] == nextColor);
////                    changeColor |= (current.colors[i + 1][j + 1] == nextColor);
//////                        next.colors[i][j] = changeColor ? nextColor : current.colors[i][j];
////                    if (changeColor) {
////                        canvas.drawRect(rectangles[i][j], paints[nextColor]);
////                        next.colors[i][j] = nextColor;
////                    } else {
////                        next.colors[i][j] = current.colors[i][j];
////                    }
////                }
////
////                int j =
////
//                swapState = current;
//                current = next;
//                next = swapState;
////            }

if (count < 100){
invalidate();
    count++;
}
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
