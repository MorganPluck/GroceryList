package com.example.grocerylist;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<GroceryItem> groceryItems;
    private RecyclerView recyclerView;
    private GroceryAdapter adapter;
    private EditText itemInputField;
    private ImageButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groceryItems = new ArrayList<>();
        groceryItems.add(new GroceryItem("Milk"));
        groceryItems.add(new GroceryItem("Bread"));
        groceryItems.add(new GroceryItem("Eggs"));

        recyclerView = findViewById(R.id.grocery_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new GroceryAdapter(groceryItems);
        recyclerView.setAdapter(adapter);

        itemInputField = findViewById(R.id.item_input);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = itemInputField.getText().toString().trim();
                if (!itemName.isEmpty()) {
                    groceryItems.add(new GroceryItem(itemName));
                    adapter.notifyItemInserted(groceryItems.size() - 1);
                    itemInputField.setText("");
                }
            }
        });
    }
}