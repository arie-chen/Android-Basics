package com.example.android.miwok;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int color;

    public WordAdapter(Activity context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        this.color = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView defaultWord = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultWord.setText(currentWord.getDefaultTranslation());
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getMiwokTranslation());
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        LinearLayout linear = (LinearLayout) listItemView.findViewById(R.id.category);
        linear.setBackgroundResource(color);

        if (currentWord.getImageResourceID() == Word.NO_PICTURE) {
            image.setVisibility(View.GONE);
        } else {
            image.setImageResource(currentWord.getImageResourceID());
            image.setVisibility(View.VISIBLE);
        }

        return listItemView;
    }

}
