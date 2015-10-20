package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class TypefaceRadioButton extends AppCompatRadioButton
{
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
