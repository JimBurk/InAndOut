package edu.orangecoastcollege.cs273.jburk.inandout;

/**
 * Created by jimburk on 9/20/17.
 */

public class Order {
    private int mDoubleDoubles;
    private int mCheeseburgers;
    private int mFrenchFries;
    private int mShakes;
    private int mSmallDrinks;
    private int mMediumDrinks;
    private int mLargeDrinks;

    private static final float PRICE_DOUBLE_DOUBLE = 3.6f;
    private static final float PRICE_CHEESEBURGER = 2.15f;
    private static final float PRICE_FRENCH_FRIES = 1.65f;
    private static final float PRICE_SHAKES = 2.2f;
    private static final float PRICE_SMALL_DRINK = 1.45f;
    private static final float PRICE_MEDIUM_DRINK = 1.55f;
    private static final float PRICE_LARGE_DRINK = 1.75f;
    private static final float TAX_RATE = 0.08f;

    public Order() {
    }

    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }

    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    public float calculateSubtotal() {
        return mDoubleDoubles * PRICE_DOUBLE_DOUBLE +
                mCheeseburgers * PRICE_CHEESEBURGER +
                mFrenchFries * PRICE_FRENCH_FRIES +
                mShakes * PRICE_SHAKES +
                mSmallDrinks * PRICE_SMALL_DRINK +
                mMediumDrinks * PRICE_MEDIUM_DRINK +
                mLargeDrinks * PRICE_LARGE_DRINK;
    }

    public float calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public float calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public int calculateNumItems() {
        return mDoubleDoubles + mCheeseburgers + mFrenchFries + mShakes + mSmallDrinks + mMediumDrinks + mLargeDrinks;
    }
}
