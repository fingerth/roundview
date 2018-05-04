package com.fingerth.round;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * ======================================================
 * Created by Administrator acg_fingerth on 2018/5/4.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class FingerthRoundView extends View {
    private int mRadius;
    private int mRadiusColor;
    private Path path2;
    private Paint mPaint;

    public FingerthRoundView(Context context) {
        super(context);
        // 获取自定义的属性
        initAttrs(context, null);
    }

    public FingerthRoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 获取自定义的属性
        initAttrs(context, attrs);
    }

    public FingerthRoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 获取自定义的属性
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            //TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FingerthRoundView, 0, 0);
            TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.FingerthRoundView);
            mRadius = (int) typeArray.getDimension(R.styleable.FingerthRoundView_radius, 0);
            mRadiusColor = typeArray.getColor(R.styleable.FingerthRoundView_radiusColor, 0xFFFFFFFF);
        } else {
            mRadius = 0;
            mRadiusColor = 0xFFFFFFFF;
        }

        //Log.v("FingerthRoundView", "mRadius = " + mRadius);

        initVariable();
    }

    private void initVariable() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mRadiusColor);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(0);
        mPaint.setStrokeCap(Paint.Cap.BUTT);//没有
        mPaint.setStrokeJoin(Paint.Join.MITER);//锐角

        path2 = new Path();


    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int h = getWidth() > getHeight() ? getHeight() / 2 : getWidth() / 2;
        if (mRadius > h) {
            mRadius = h;
        }

        //Log.v("FingerthRoundView", "onDraw()  mRadius = " + mRadius);
        //getWidth();
        //getHeight();

        //top_left
        path2.moveTo(0, 0);
        path2.lineTo(0, mRadius);
        path2.arcTo(new RectF(0, 0, mRadius * 2, mRadius * 2), 180, 90);
        path2.lineTo(mRadius, 0);
        path2.lineTo(0, 0);
        path2.close();
        canvas.drawPath(path2, mPaint);

        //top_right
        path2.moveTo(getWidth(), 0);
        path2.lineTo(getWidth() - mRadius, 0);
        path2.arcTo(new RectF(getWidth() - (mRadius * 2), 0, getWidth(), mRadius * 2), 270, 90);
        path2.lineTo(getWidth(), mRadius);
        path2.lineTo(getWidth(), 0);
        path2.close();
        canvas.drawPath(path2, mPaint);

        //bottom_right
        path2.moveTo(getWidth(), getHeight());
        path2.lineTo(getWidth(), getHeight() - mRadius);
        path2.arcTo(new RectF(getWidth() - mRadius * 2, getHeight() - mRadius * 2, getWidth(), getHeight()), 0, 90);
        path2.lineTo(getWidth() - mRadius, getHeight());
        path2.lineTo(getWidth(), getHeight());
        path2.close();
        canvas.drawPath(path2, mPaint);

        //bottom_left
        path2.moveTo(0, getHeight());
        path2.lineTo(mRadius, getHeight());
        path2.arcTo(new RectF(0, getHeight() - mRadius * 2, mRadius * 2, getHeight()), 90, 90);
        path2.lineTo(0, getHeight() - mRadius);
        path2.lineTo(0, getHeight());
        path2.close();
        canvas.drawPath(path2, mPaint);

    }
}
