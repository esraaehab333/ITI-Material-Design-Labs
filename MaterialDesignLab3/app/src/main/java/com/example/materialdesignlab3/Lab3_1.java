package com.example.materialdesignlab3;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab3_1 extends AppCompatActivity {

    private Chip chipFastDelivery;
    private Chip chipPickup;
    private Chip chipBestOffer;
    private Chip chipFastSelling;
    private ListView listViewFoodItems;
    private FoodItemAdapter adapter;
    private List<FoodItem> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        chipFastDelivery = findViewById(R.id.chipFastDelivery);
        chipPickup = findViewById(R.id.chipPickup);
        chipBestOffer = findViewById(R.id.chipBestOffer);
        chipFastSelling = findViewById(R.id.chipFastSelling);
        listViewFoodItems = findViewById(R.id.listViewFoodItems);

        if (chipFastDelivery == null || chipPickup == null ||
                chipBestOffer == null || chipFastSelling == null ||
                listViewFoodItems == null) {
            throw new RuntimeException("One or more views not found in layout. Check your XML IDs.");
        }

        initializeFoodItems();

        adapter = new FoodItemAdapter(this, foodItems);
        listViewFoodItems.setAdapter(adapter);
        setupChipListeners();
        applyFilters();
    }

    private void initializeFoodItems() {
        foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("Food 1", Arrays.asList("Fast Delivery")));
        foodItems.add(new FoodItem("Food 2", Arrays.asList("Pickup")));
        foodItems.add(new FoodItem("Food 3", Arrays.asList("Best Offer")));
        foodItems.add(new FoodItem("Food 4", Arrays.asList("Fast Delivery", "Best Offer")));
        foodItems.add(new FoodItem("Food 5", Arrays.asList("Fast Delivery")));
        foodItems.add(new FoodItem("Food 6", Arrays.asList("Pickup", "Fast Selling")));
        foodItems.add(new FoodItem("Food 7", Arrays.asList("Fast Delivery")));
        foodItems.add(new FoodItem("Food 8", Arrays.asList("Fast Selling")));
        foodItems.add(new FoodItem("Food 9", Arrays.asList("Best Offer", "Fast Selling")));
        foodItems.add(new FoodItem("Food 10", Arrays.asList("Pickup", "Best Offer")));
    }

    private void setupChipListeners() {
        chipFastDelivery.setOnCheckedChangeListener((buttonView, isChecked) -> applyFilters());
        chipPickup.setOnCheckedChangeListener((buttonView, isChecked) -> applyFilters());
        chipBestOffer.setOnCheckedChangeListener((buttonView, isChecked) -> applyFilters());
        chipFastSelling.setOnCheckedChangeListener((buttonView, isChecked) -> applyFilters());
    }

    private void applyFilters() {
        List<String> selectedTags = new ArrayList<>();

        if (chipFastDelivery.isChecked()) {
            selectedTags.add("Fast Delivery");
        }
        if (chipPickup.isChecked()) {
            selectedTags.add("Pickup");
        }
        if (chipBestOffer.isChecked()) {
            selectedTags.add("Best Offer");
        }
        if (chipFastSelling.isChecked()) {
            selectedTags.add("Fast Selling");
        }
        adapter.filter(selectedTags);
    }
}