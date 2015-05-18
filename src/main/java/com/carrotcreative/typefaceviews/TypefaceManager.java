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
        mTypefaces.put(key, fileName);
        return this;
    }

    Typeface obtainTypeface(Context context, int typefaceValue) throws IllegalArgumentException
    {
        Typeface typeface = mCompiledTypefaces.get(typefaceValue);
        if (typeface == null)
        {
            typeface = createTypeface(context, typefaceValue);
            mCompiledTypefaces.put(typefaceValue, typeface);
        }

        return typeface;
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
