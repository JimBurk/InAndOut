package edu.orangecoastcollege.cs273.jburk.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView mTotalView = (TextView) findViewById(R.id.totalTextView);
        TextView mReportView = (TextView) findViewById(R.id.totalTextView);

        Intent intentFromMain = getIntent();

        String totalReq = intentFromMain.getStringExtra("total");
        mTotalView.setText(totalReq);

        String totalString = intentFromMain.getStringExtra("report");
        mReportView.setText(totalString);
    }

    public void newOrder(View v) {
        this.finish();
    }
}
