package com.techdb.databindingobservable.vectordrawablevspng;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.techdb.databindingobservable.R;

/**
 * Created by le.quang.hoa on 11/29/16.
 */

public class MeasureActivity extends AppCompatActivity {

    private TextView mDurationText;
    private MeasureableImageView mMeasureableImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measure_drawable_vs_png);

        mDurationText = (TextView) findViewById(R.id.draw_duration_text);
        mMeasureableImageView = (MeasureableImageView) findViewById(R.id.measurable_image);

        mMeasureableImageView.setViewRedrawnListener(this::updateDuration);

        RadioGroup group = (RadioGroup) findViewById(R.id.drawable_choice);
        group.setOnCheckedChangeListener((group1, checkedId) -> onImageTypeChanged(checkedId));
        group.check(R.id.vector_drawable_button);

    }

    private void updateDuration(final double miliseconds) {
        assert mDurationText != null;

        mDurationText.setText(getString(R.string.duration, miliseconds));
    }

    private void onImageTypeChanged(@IdRes final int checkedId) {
        switch (checkedId) {
            case R.id.vector_drawable_button:
                vectorDrawableSelected();
                break;
            case R.id.png_button:
                pngSelected();
                break;
        }
    }

    private void vectorDrawableSelected() {
        mMeasureableImageView.setImageResource(R.drawable.placeholder);
    }

    private void pngSelected() {
        mMeasureableImageView.setImageResource(R.drawable.placeholder_png);
    }
}
