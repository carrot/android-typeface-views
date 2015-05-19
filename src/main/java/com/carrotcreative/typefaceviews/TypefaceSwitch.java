package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Switch;

public class TypefaceSwitch extends Switch {

    public TypefaceSwitch(Context context)
    {
        super(context);
    }

    public TypefaceSwitch(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public TypefaceSwitch(Context context, AttributeSet attrs, int defStyleAttr)
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
