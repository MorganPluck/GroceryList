package com.example.grocerylist_pluck;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView itemTextView;
    ImageButton deleteButton;

    public GroceryViewHolder(View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.item_text);
        deleteButton = itemView.findViewById(R.id.delete_button);
    }
}
