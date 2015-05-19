package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class TypefaceUtil {

    /**
     * Fetches the typeface from the attributes and returns an actual
     * android.graphics.Typeface.
     *
     * An IllegalArgumentException is thrown down further down the chain
     * if a typeface couldn't be generated.
     */
    static android.graphics.Typeface getTypeface(Context context, AttributeSet attrs)
    {
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

        return TypefaceManager.getInstance().obtainTypeface(context, typefaceValue);
    }

}
