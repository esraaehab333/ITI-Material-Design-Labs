package com.example.materialdesignlab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.materialdesignlab3.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class FoodItemAdapter extends BaseAdapter {
    private Context context;
    private List<FoodItem> foodItems;
    private List<FoodItem> filteredFoodItems;
    private LayoutInflater inflater;

    public FoodItemAdapter(Context context, List<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
        this.filteredFoodItems = new ArrayList<>(foodItems);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filteredFoodItems.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredFoodItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.food_item, parent, false);
            holder = new ViewHolder();
            holder.textViewFoodName = convertView.findViewById(R.id.textViewFoodName);
            holder.textViewDeliveryType = convertView.findViewById(R.id.textViewDeliveryType);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FoodItem foodItem = filteredFoodItems.get(position);
        holder.textViewFoodName.setText(foodItem.getName());
        holder.textViewDeliveryType.setText(foodItem.getTagsAsString());

        return convertView;
    }

    public void filter(List<String> selectedTags) {
        filteredFoodItems.clear();

        if (selectedTags == null || selectedTags.isEmpty()) {
            // No filters selected, show all items
            filteredFoodItems.addAll(foodItems);
        } else {
            // Show items that match any of the selected tags
            for (FoodItem item : foodItems) {
                if (item.hasAnyTag(selectedTags)) {
                    filteredFoodItems.add(item);
                }
            }
        }

        notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView textViewFoodName;
        TextView textViewDeliveryType;
    }
}