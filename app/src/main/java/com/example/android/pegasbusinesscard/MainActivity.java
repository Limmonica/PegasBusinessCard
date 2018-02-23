package com.example.android.pegasbusinesscard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the ViewPager view in activity_main.xml
        viewPager = findViewById(R.id.viewPager);
        // Create an adapter for the ViewPager
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        // Connect the adapter and the ViewPager view
        viewPager.setAdapter(viewPagerAdapter);
        // Create timer for the slides
        Timer timer = new Timer();
        // Setup the time for each slide to be visible and delayed
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        // Touching the button "Directions" will open Google Maps at the exact location of the shop
        Button addressMap = findViewById(R.id.address_map);
        addressMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasMap = getString(R.string.pegas_map);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pegasMap));
                startActivity(mapIntent);
            }
        });
        // Touching the button "Call" will open the dialer of the phone
        Button numberCall = findViewById(R.id.phone);
        numberCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasPhone = getString(R.string.phone_no);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.phone_label) + pegasPhone));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }
            }
        });
        // Touching the button "Visit" will open the Website in the browser
        Button urlWebsite = findViewById(R.id.website);
        urlWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasWebsite = getString(R.string.website_address);
                Intent visitWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(pegasWebsite));
                startActivity(visitWebsite);
            }
        });
        // Touching the Facebook social icon will open the Facebook app and go to Pegas Facebook page
        ImageView socialFacebook = findViewById(R.id.facebook);
        socialFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasFacebookPageURL = getString(R.string.facebook_page);
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pegasFacebookPageURL));
                startActivity(facebookIntent);
            }
        });
        // Touching the Instagram social icon will open the Instagram app and go to Pegas Instagram page
        ImageView socialInstagram = findViewById(R.id.instagram);
        socialInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasInstagramURL = getString(R.string.instagram_page);
                Intent socialInstagram = new Intent(Intent.ACTION_VIEW, Uri.parse(pegasInstagramURL));
                startActivity(socialInstagram);
            }
        });
        // Touching the YouTube social icon will open the YouTube app and go to Pegas YouTube channel
        ImageView socialYoutube = findViewById(R.id.youtube);
        socialYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasYouTubeURL = getString(R.string.youtube_channel);
                Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pegasYouTubeURL));
                startActivity(youtubeIntent);
            }
        });
        // Touching the Twitter social icon will open the Twitter app and go to Pegas Twitter account
        ImageView socialTwitter = findViewById(R.id.twitter);
        socialTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pegasTwitterURL = getString(R.string.twitter_account);
                Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pegasTwitterURL));
                startActivity(twitterIntent);
            }
        });
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                //setup the logic of the slides
                @Override
                public void run() {
                    viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % 7);
                }
            });
        }
    }
}
