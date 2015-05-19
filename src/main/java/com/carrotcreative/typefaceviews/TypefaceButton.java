package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class TypefaceButton extends Button {

    public TypefaceButton(Context context)
    {
        super(context);
    }

    public TypefaceButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public TypefaceButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    protected void init(Context context, AttributeSet attrs)
    {
        if (isInEditMode()) return;
        setTypeface(TypefaceUtil.getTypeface(context, attrs));
    }

}
