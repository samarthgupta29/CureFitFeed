package com.example.curefitfeed.model;

public class FoodItem implements CustomListItem {

    private Food food;

    public FoodItem(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public int getType() {
        return CustomListItem.TYPE_FOOD;
    }
}
