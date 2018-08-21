package com.durga.balaji66.toastmessage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mNormalToastMessage;
    private TextView mCustomizedToastMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    public void initializeViews()
    {
        mNormalToastMessage = (TextView)findViewById(R.id.textViewNormalToast);
        mCustomizedToastMessage = (TextView)findViewById(R.id.textViewCustomizedToast);
    }
    public void initializeListeners()
    {
        mNormalToastMessage.setOnClickListener(this);
        mCustomizedToastMessage.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.textViewNormalToast:
                Toast.makeText(getApplicationContext(),"This is normal Toast message",Toast.LENGTH_LONG).show();
                break;
            case R.id.textViewCustomizedToast:
                Toast toast = Toast.makeText(this, "I am custom Toast!", Toast.LENGTH_LONG);
                View toastView = toast.getView(); // This'll return the default View of the Toast.

                /* And now you can get the TextView of the default View of the Toast. */
                TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
                toastMessage.setTextSize(25);
                toastMessage.setTextColor(Color.RED);
                toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons_dragonfly, 0, R.drawable.icons_dragonfly, 0);
                toastMessage.setGravity(Gravity.CENTER);
                //toastMessage.setBackgroundColor(getResources().getColor(R.color.colorNavyblue));
                //toastMessage.setCompoundDrawablePadding(16);
                //toastMessage.setBackground(new ColorDrawable(R.drawable.dialog_bg));
                //toastView.setBackgroundColor(R.drawable.dialog_bg);
                toast.show();

                break;
        }
    }
}
