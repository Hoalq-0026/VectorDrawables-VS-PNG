package com.techdb.databindingobservable.vectordrawablevspng;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * ImageView that measure the time took to draw.
 */

public class MeasureableImageView extends ImageView {

    private ViewRedrawnListener mViewRedrawnListener;


    public MeasureableImageView(Context context) {
        super(context);
    }

    public MeasureableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setViewRedrawnListener(@NonNull final ViewRedrawnListener viewRedrawnListener) {
        mViewRedrawnListener = viewRedrawnListener;
    }


    /**
     * Measure the time that the {@link ImageView#onDraw(Canvas)} method took and then notify
     * the listeners when the re-draw has finished, with the duration for the draw.
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        long startTime = System.nanoTime();

        super.onDraw(canvas);

        long endTime = System.nanoTime();

        notifyDraw(startTime, endTime);

    }

    private void notifyDraw(final double startTimeNano, final double endTimeNano) {
        double durationMilliseconds = (endTimeNano - startTimeNano) / 1000000;

        if (mViewRedrawnListener != null) {
            mViewRedrawnListener.onDrawfinished(durationMilliseconds);
        }
    }
}
