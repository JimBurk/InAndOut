package edu.orangecoastcollege.cs273.jburk.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OrderActivity extends AppCompatActivity {
    private EditText mDoubleEntry;
    private EditText mCheeserEntry;
    private EditText mFriesEntry;
    private EditText mShakesEntry;
    private EditText mSmallEntry;
    private EditText mMediumEntry;
    private EditText mLargeEntry;

    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        order = new Order();
        setContentView(R.layout.activity_order);

        mDoubleEntry = (EditText) findViewById(R.id.doubleEntry);
        mCheeserEntry = (EditText) findViewById(R.id.cheeseEntry);
        mFriesEntry = (EditText) findViewById(R.id.friesEntry);
        mShakesEntry = (EditText)findViewById(R.id.skakesEntry);
        mSmallEntry = (EditText) findViewById(R.id.smallEntry);
        mMediumEntry = (EditText) findViewById(R.id.mediumEntry);
        mLargeEntry = (EditText) findViewById(R.id.largeEntry);
    }

    public void PlaceOrder (View v) {
        order.setDoubleDoubles(Integer.parseInt(mDoubleEntry.getText().toString()));
        order.setCheeseburgers(Integer.parseInt(mCheeserEntry.getText().toString()));
        order.setFrenchFries(Integer.parseInt(mFriesEntry.getText().toString()));
        order.setShakes(Integer.parseInt(mShakesEntry.getText().toString()));
        order.setSmallDrinks(Integer.parseInt(mSmallEntry.getText().toString()));
        order.setMediumDrinks(Integer.parseInt(mMediumEntry.getText().toString()));
        order.setLargeDrinks(Integer.parseInt(mLargeEntry.getText().toString()));

        Intent myIntent = new Intent(this, SummaryActivity.class);
        myIntent.putExtra("total", "Order Total  $" + order.calculateTotal());

        myIntent.putExtra("report", "Items Ordered:  " + order.calculateNumItems() +
        "\nSubtotal:   $ " + order.calculateSubtotal() + "\nTax (8%):   $ " + order.calculateTax());

        this.startActivity(myIntent);
    }
}
