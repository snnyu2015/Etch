package com.example.nyuscps.etch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class EtchView extends View {
    final Path path = new Path();
    final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);




    public EtchView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        String s = "Tilt screen to start new sketch";
        Toast toast = Toast.makeText(getContext(), s, Toast.LENGTH_SHORT);
        toast.show();

        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        path.moveTo(event.getX(), event.getY());
                        invalidate();	//call onDraw
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        path.lineTo(event.getX(), event.getY());
                        invalidate();	//call onDraw
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);	//background
        canvas.drawPath(path, paint);




    }
}
