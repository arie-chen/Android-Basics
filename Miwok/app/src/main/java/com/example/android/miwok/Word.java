package com.example.android.miwok;

/**
 * Word represents a vocabulary word that the user wants to learn
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    /** Default translation of the word */
    private String mDefaultTranslation;

    /** Miwok translation of the word */
    private String mMiwokTranslation;

    /** ImageResourceID of the word */
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /** If there is no image */
    public static final int NO_IMAGE_PROVIDED = -1;


    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID) {
        this(defaultTranslation, miwokTranslation);
        mImageResourceID = imageResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

}
