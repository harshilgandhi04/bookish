package com.example.android.book_hub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.author;
import static android.R.attr.rating;
import static android.R.attr.resource;

/**
 * Created by Hiral on 09-04-2017.
 */

public class ProfileAdapter extends ArrayAdapter<String> {
    int[] image={};
    String[] book={};
    String[] author={};
    String[] rating={};
    Context c;
    LayoutInflater inflater;

    public ProfileAdapter(Context context, String[] book,String[] author,String[] rating,int[] image) {
        super(context, R.layout.list_item,book);

        this.c=context;
        this.book=book;
        this.author=author;
        this.rating=rating;
        this.image=image;
    }

    public class ViewHolder{
        TextView bookname;
        TextView authorname;
        TextView ratings;
        ImageView bookpic;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item,null);
        }

        final ViewHolder holder=new ViewHolder();

        //Initialize our view
        holder.bookname=(TextView) convertView.findViewById(R.id.bookNameTextView);
        holder.authorname=(TextView) convertView.findViewById(R.id.authorNameTextView);
        holder.ratings=(TextView) convertView.findViewById(R.id.score);
        holder.bookpic=(ImageView) convertView.findViewById(R.id.bookCoverView);

        //Assign Data
        holder.bookname.setText(book[position]);
        holder.authorname.setText(author[position]);
        holder.ratings.setText(rating[position]);
        holder.bookpic.setImageResource(image[position]);
        return convertView;
    }
}
