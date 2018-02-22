package com.example.android.book_hub;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WittyStarLord on 03/04/17.
 */

public class bookAdapter extends ArrayAdapter<book> {

    public bookAdapter(Activity context, ArrayList<book> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        book currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.bookNameTextView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getmNameOfBook());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.authorNameTextView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getmNameOfAuthor());

        //get the image from the word object and set this image to the ImageView.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.bookCoverView);
        imageView.setImageResource(currentWord.getImageResourceId());
        //Check if an image view is provided for this view
        TextView scoreTextView = (TextView) listItemView.findViewById(R.id.score);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        scoreTextView.setText(currentWord.getmScore());


        return listItemView;
    }

}