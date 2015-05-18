package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public abstract class TypefaceTextView extends TextView {

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
        preInit(context, attrs);

        if (isInEditMode()) return;

        final int typefaceValue;
        if (attrs != null)
        {
            TypedArray values = context.obtainStyledAttributes(attrs, getTextViewStyleable());
            typefaceValue = values.getInt(getTypefaceAttribute(), 1);
            values.recycle();
        }
        else
        {
            typefaceValue = -1;
        }

        setTypeface(TypefaceManager.getInstance().obtainTypeface(context, typefaceValue));
    }

    protected abstract int[] getTextViewStyleable();

    protected abstract int getTypefaceAttribute();

    protected void preInit(Context context, AttributeSet attrs)
    {
        /** Do Nothing, optional to override */
    }

}
