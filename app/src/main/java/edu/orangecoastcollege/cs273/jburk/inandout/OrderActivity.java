package edu.orangecoastcollege.cs273.jburk.inandout;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    public NumberFormat money = NumberFormat.getCurrencyInstance();

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

    protected void onRestart() {
        super.onRestart();

        order.setDoubleDoubles(0);
        order.setCheeseburgers(0);
        order.setFrenchFries(0);
        order.setShakes(0);
        order.setSmallDrinks(0);
        order.setMediumDrinks(0);
        order.setLargeDrinks(0);

        mDoubleEntry.setText("0");
        mCheeserEntry.setText("0");
        mFriesEntry.setText("0");
        mShakesEntry.setText("0");
        mSmallEntry.setText("0");
        mMediumEntry.setText("0");
        mLargeEntry.setText("0");
    }

    public void PlaceOrder (View v) {
        order.setDoubleDoubles(Integer.parseInt(mDoubleEntry.getText().toString()));
        order.setCheeseburgers(Integer.parseInt(mCheeserEntry.getText().toString()));
        order.setFrenchFries(Integer.parseInt(mFriesEntry.getText().toString()));
        order.setShakes(Integer.parseInt(mShakesEntry.getText().toString()));
        order.setSmallDrinks(Integer.parseInt(mSmallEntry.getText().toString()));
        order.setMediumDrinks(Integer.parseInt(mMediumEntry.getText().toString()));
        order.setLargeDrinks(Integer.parseInt(mLargeEntry.getText().toString()));

        String totalFormatted = money.format(order.calculateTotal());

        Intent myIntent = new Intent(this, SummaryActivity.class);
        myIntent.putExtra("total", "Order Total  " + totalFormatted);

        String subtotalFormatted = money.format(order.calculateSubtotal());
        String taxFormatted = money.format(order.calculateTax());

        myIntent.putExtra("report", "Items Ordered:\t\t" + order.calculateNumItems() +
        "\nSubtotal:\t\t\t" + subtotalFormatted + "\nTax (8%):\t\t\t\t" + taxFormatted);

        this.startActivity(myIntent);
    }
}
