package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class TypefaceEditText extends EditText {

    public TypefaceEditText(Context context)
    {
        super(context);
    }

    public TypefaceEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public TypefaceEditText(Context context, AttributeSet attrs, int defStyleAttr)
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
