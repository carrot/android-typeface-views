package com.carrotcreative.typefaceviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;

public class TypefaceManager {

    // ========== Singleton ==========

    private static TypefaceManager sInstance;

    public static TypefaceManager getInstance()
    {
        if(sInstance == null)
        {
            sInstance = new TypefaceManager();
        }
        return sInstance;
    }

    // ========== Class ==========

    private final SparseArray<String> mTypefaces = new SparseArray<>();
    private final SparseArray<Typeface> mCompiledTypefaces = new SparseArray<>();
    private int[] mTypefaceViewStyleable;
    private int mTypefaceAttribute;
    private int mDefaultTypefaceAttribute = -1;
    private int mLastTypefaceAttributeSet = -1;

    private TypefaceManager() { /** Do Nothing */ }

    /**
     * Registers a Typeface file that all Typeface Views
     * can access
     *
     * @param key This should match up with the attribute values
     * @param fileName The filename of the font that is located in
     *                 assets/fonts/
     */
    public TypefaceManager registerTypeface(int key, String fileName)
    {
        mLastTypefaceAttributeSet = key;
        mTypefaces.put(key, fileName);
        return this;
    }

    /**
     * Sets the TypefaceView styleable
     */
    public TypefaceManager setTypefaceViewStyleable(int[] textViewStyleable)
    {
        mTypefaceViewStyleable = textViewStyleable;
        return this;
    }

    /**
     * Sets the TypefaceView typeface attribute
     */
    public TypefaceManager setTypefaceAttribute(int attribute)
    {
        mTypefaceAttribute = attribute;
        return this;
    }

    /**
     * Sets the last value registered with {@link #registerTypeface}
     * as the default value
     */
    public TypefaceManager asDefault()
    {
        if(mLastTypefaceAttributeSet == -1)
        {
            throw new IllegalStateException("Cannot call asDefault, as there was no typeface set yet");
        }
        mDefaultTypefaceAttribute = mLastTypefaceAttributeSet;
        return this;
    }

    public Typeface obtainTypeface(Context context, int typefaceValue) throws IllegalArgumentException
    {
        Typeface typeface = mCompiledTypefaces.get(typefaceValue);
        if (typeface == null)
        {
            typeface = createTypeface(context, typefaceValue);
            mCompiledTypefaces.put(typefaceValue, typeface);
        }

        return typeface;
    }

    int[] getTypefaceViewStyleable()
    {
        return mTypefaceViewStyleable;
    }

    int getTypefaceAttribute()
    {
        return mTypefaceAttribute;
    }

    int getDefaultAttribute()
    {
        if(mDefaultTypefaceAttribute == -1)
        {
            throw new IllegalStateException("There is no default typeface attribute set");
        }
        return mDefaultTypefaceAttribute;
    }

    private Typeface createTypeface(Context context, int typefaceValue) throws IllegalArgumentException
    {
        Typeface typeface;

        String fileName = mTypefaces.get(typefaceValue);
        if(fileName == null)
        {
            throw new IllegalArgumentException("Unknown `typeface` attribute value " + typefaceValue);
        }
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fileName);
        return typeface;
    }

}
