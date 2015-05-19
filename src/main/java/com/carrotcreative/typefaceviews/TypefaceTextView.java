package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypefaceTextView extends TextView {

    public TypefaceTextView(Context context)
    {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    protected void init(Context context, AttributeSet attrs)
    {
        if (isInEditMode()) return;
        setTypeface(TypefaceUtil.getTypeface(context, attrs));
    }

}
