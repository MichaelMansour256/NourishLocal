package com.example.fr3on.nourishlocal;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fr3on.nourishlocal.model.community;


public class DetailesActivity extends AppCompatActivity {

    private String friendname;
    private ImageView typeImageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button shareButton;
    private community community;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        friendname=getIntent().getStringExtra(getString(R.string.frieng_name_key));
        community =(community) getIntent().getSerializableExtra(getString(R.string.community_key));
        typeImageView = findViewById(R.id.typeImageView);
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        shareButton=findViewById(R.id.shareButton);



        typeImageView.setImageResource(community.getImageReference());
        titleTextView.setText(community.getName());
        descriptionTextView.setText(community.getDescription());
        shareButton.setText(String.format("%s %s",getString(R.string.share_With),friendname));
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent =new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String msg = String.format("%s: %s",friendname,community.getDescription());
                shareIntent.putExtra(Intent.EXTRA_TEXT,msg);
                startActivity(Intent.createChooser(shareIntent,getString(R.string.app_name)));
            }
        });

    }

}
