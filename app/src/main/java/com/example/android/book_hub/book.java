package com.example.android.book_hub;

/**
 * Created by WittyStarLord on 03/04/17.
 */

public class book {
    //Name of the book.
 private String mNameOfBook;

    //Name of the author
    private String mNameOfAuthor;

    //image
    private int mImageResourceId;

    //Goodreads Score
    private String mScore;

    private static final int No_IMAGE_PROVIDED = -1;

    /**
     * This constructor is used to send the name of the book, author of the book and the cover image of the book.
     * @param nameOfBook
     * @param nameOfAuthor
     * @param imageResourceId
     */
    public book(String nameOfBook, String nameOfAuthor, int imageResourceId, String score) {

        mNameOfBook = nameOfBook;

        mNameOfAuthor = nameOfAuthor;

        mImageResourceId = imageResourceId;

        mScore =score;

    }



    //This method to get the default translation.
    public String getmNameOfBook() {
        return mNameOfBook;
    }

    //This method to get the miwok translation.
    public String getmNameOfAuthor() {
        return mNameOfAuthor;
    }

    //This method wil get the image realted to the translation
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // This method will get the score
    public String getmScore(){return mScore;
    }

    }



