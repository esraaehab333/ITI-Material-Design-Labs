package com.example.materialdesignlab3;

import java.util.ArrayList;
import java.util.List;

public class FoodItem {
    private String name;
    private List<String> tags;

    public FoodItem(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTagsAsString() {
        if (tags == null || tags.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tags.size(); i++) {
            sb.append(tags.get(i));
            if (i < tags.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public boolean hasTag(String tag) {
        return tags != null && tags.contains(tag);
    }

    public boolean hasAnyTag(List<String> tagList) {
        if (tags == null || tags.isEmpty() || tagList == null || tagList.isEmpty()) {
            return false;
        }
        for (String tag : tagList) {
            if (tags.contains(tag)) {
                return true;
            }
        }
        return false;
    }
}