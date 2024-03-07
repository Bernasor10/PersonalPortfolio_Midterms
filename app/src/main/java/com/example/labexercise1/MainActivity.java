package com.example.labexercise1;
import android.view.View;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Hide the title in the toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Setup for Notification Icon in the Toolbar
        ImageView notificationIcon = toolbar.findViewById(R.id.notification_icon);
        notificationIcon.setOnClickListener(view -> {
            // Handle notification icon click
            // TODO: Define what happens when notification icon is clicked
        });

// Find the Follow button
        AppCompatButton followButton = findViewById(R.id.follow_button);

// Define a boolean flag to track the button state
        final boolean[] isFollowing = {false};

// Set an OnClickListener
        followButton.setOnClickListener(view -> {
            // Check the current state of the button
            if (isFollowing[0]) {
                // If currently following, revert to "Follow" state
                followButton.setText("Follow");
                followButton.setBackground(getResources().getDrawable(R.drawable.button_shadow));
                isFollowing[0] = false;
            } else {
                // If currently not following, change to "Following" state
                followButton.setText("Following  ▾");
                followButton.setBackground(getResources().getDrawable(R.drawable.button_background));
                isFollowing[0] = true;
            }
        });

        // Find the back button
        ImageView backButton = findViewById(R.id.back_button);

// Set an OnClickListener
        backButton.setOnClickListener(view -> {
            // Open the YouTube link
            openWebPage("https://www.youtube.com/watch?v=q-Y0bnx6Ndw");
        });

        ImageView linkedInIcon = findViewById(R.id.linkedin_icon);
        ImageView facebookIcon = findViewById(R.id.facebook_icon);
        ImageView instagramIcon = findViewById(R.id.instagram_icon);

        linkedInIcon.setOnClickListener(view -> openWebPage("https://www.linkedin.com/in/ronaldo-bernasorii-b987761b3/"));
        facebookIcon.setOnClickListener(view -> openWebPage("https://www.facebook.com/maximuslincoln010/"));
        instagramIcon.setOnClickListener(view -> openWebPage("https://www.instagram.com/potatolicious.10/"));

        TextView textViewPosts = findViewById(R.id.Posts);
        TextView textViewFollowers = findViewById(R.id.Followers);
        TextView textViewFollowing = findViewById(R.id.Following);

        setBoldText(textViewPosts);
        setBoldText(textViewFollowers);
        setBoldText(textViewFollowing);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_report) {
            // Handle Report action
            return true;
        } else if (itemId == R.id.action_block) {
            // Handle Block action
            return true;
        } else if (itemId == R.id.action_notification) {
            // Handle notification icon click
            // You can add your own logic here
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void setBoldText(TextView textView) {
        String text = textView.getText().toString();
        SpannableStringBuilder sb = new SpannableStringBuilder(text);
        sb.setSpan(new StyleSpan(Typeface.BOLD), 0, text.indexOf("\n"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(sb);
    }
}