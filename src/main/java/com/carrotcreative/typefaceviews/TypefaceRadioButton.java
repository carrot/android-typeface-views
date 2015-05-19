package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class TypefaceRadioButton extends RadioButton {

    public TypefaceRadioButton(Context context)
    {
        super(context);
    }

    public TypefaceRadioButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public TypefaceRadioButton(Context context, AttributeSet attrs, int defStyleAttr)
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
