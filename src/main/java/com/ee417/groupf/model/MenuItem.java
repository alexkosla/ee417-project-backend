package com.ee417.groupf.model;

import java.util.UUID;

public class MenuItem {
    private UUID MenuItemId;

    private String Name;

    private String Description;

    private MenuItemCategoryEnum Category;

    private String PictureLocation;

    private float Price;

    private int Calories;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public UUID getMenuItemId() {
        return MenuItemId;
    }

    public void setMenuItemId(UUID menuItemId) {
        MenuItemId = menuItemId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public MenuItemCategoryEnum getCategory() {
        return Category;
    }

    public void setCategory(MenuItemCategoryEnum category) {
        Category = category;
    }

    public String getPictureLocation() {
        return PictureLocation;
    }

    public void setPictureLocation(String pictureLocation) {
        PictureLocation = pictureLocation;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int calories) {
        Calories = calories;
    }
}
