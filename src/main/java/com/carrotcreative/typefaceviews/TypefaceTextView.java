package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.content.res.TypedArray;
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
        preInit(context, attrs);

        if (isInEditMode()) return;

        final int typefaceValue;
        if (attrs != null)
        {
            int[] styleable = TypefaceManager.getInstance().getTypefaceViewStyleable();
            int attributes = TypefaceManager.getInstance().getTypefaceAttribute();

            TypedArray values = context.obtainStyledAttributes(attrs, styleable);
            int tempTypefaceValue = values.getInt(attributes, -1);
            if(tempTypefaceValue != -1)
            {
                typefaceValue = tempTypefaceValue;
            }
            else
            {
                typefaceValue = TypefaceManager.getInstance().getDefaultAttribute();
            }

            values.recycle();
        }
        else
        {
            typefaceValue = -1;
        }

        setTypeface(TypefaceManager.getInstance().obtainTypeface(context, typefaceValue));
    }

    protected void preInit(Context context, AttributeSet attrs)
    {
        /** Do Nothing, optional to override */
    }

}
