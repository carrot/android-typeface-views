# Android Typeface Views

A collection of Android views with out of the box custom font support.

## Usage

#### Font files

Place your font files directly into `/app/src/main/assets/fonts`.

#### XML attributes

In a resources file (probably attrs.xml) declare a custom styleable.  There will also be an attribute for each type of typeface.

```xml
<declare-styleable name="TypefaceView">
    <attr name="typeface"/>
</declare-styleable>

<attr name="typeface" format="enum">
    <enum name="light"      value="1" />
    <enum name="regular"    value="2" />
    <enum name="bold"       value="3" />
</attr>
```

#### Preparing the Typeface Manager

We can now create our TypefaceManager, which is a singleton object that manages all of the TypefaceViews.

There are four functions you can call on the TypefaceManager.

`setTypefaceViewStyleable`: Links the Styleable property to the TypefaceManager.  This is required.

`setTypefaceAttribute`: Links the typeface attribute of that styleable property.  This is required.

`registerTypeface`: This registers a typeface to the TypefaceManger.  The keys must match up with the values in your typeface attribute.

`asDefault`: Sets the last registered typeface as the default.  While this is not required, this is strongly recommended as you will crash out the first time you forget to set the typeface if you do not include this.

```java
TypefaceManager.getInstance()
    .setTypefaceViewStyleable(R.styleable.TypefaceView)
    .setTypefaceAttribute(R.styleable.TypefaceView_typeface)
    .registerTypeface(1, "OpenSans-Light.ttf")
    .registerTypeface(2, "OpenSans-Regular.ttf").asDefault()
    .registerTypeface(3, "OpenSans-Bold.ttf");
```

You're going to want to put this somewhere before any views are inflated.  I find that the application file is a good place for this.
