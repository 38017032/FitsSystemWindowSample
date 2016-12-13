package com.egos.fitssystemwindow.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/**
 * Created by Egos on 16/12/13.
 */
public class TestWindowInsetFrameLayout extends FrameLayout {

    private WindowInsets mLastInsets;

    // View、ImageView可以铺在status bar下方。Button等在Status的下方
    public TestWindowInsetFrameLayout(Context context) {
        super(context, null);
    }

    public TestWindowInsetFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public TestWindowInsetFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        for (int i = 0, z = getChildCount(); i < z; i++) {
            final View child = getChildAt(i);
            // 对于没有设置android:fitsSystemWindows="true"的可以将其下移一段距离
            if (!ViewCompat.getFitsSystemWindows(child) && mLastInsets != null) {
                final int insetTop = mLastInsets.getSystemWindowInsetTop();
                Log.e("fanzhang", "inset top = " + insetTop);
                if (child.getTop() < insetTop) {
                    ViewCompat.offsetTopAndBottom(child, insetTop);
                }
            }
        }
    }

    // 用来将dispatchApplyWindowInsets()传递下去。
    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchApplyWindowInsets(insets);
        }
        mLastInsets = insets;
        return insets;
    }
}
