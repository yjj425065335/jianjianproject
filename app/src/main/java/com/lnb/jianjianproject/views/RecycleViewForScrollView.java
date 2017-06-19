package com.lnb.jianjianproject.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 17/4/13.
 */

public class RecycleViewForScrollView extends RecyclerView {
    public RecycleViewForScrollView(Context context) {
        super(context);
    }

    public RecycleViewForScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecycleViewForScrollView(Context context, AttributeSet attrs,
                                    int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    /**
     * 重写该方法，达到使RecycleView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
