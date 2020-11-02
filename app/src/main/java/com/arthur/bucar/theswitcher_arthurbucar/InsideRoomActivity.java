package com.arthur.bucar.theswitcher_arthurbucar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;

public class InsideRoomActivity extends AppCompatActivity {
    String room;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_room);
        TextView textView = (TextView) findViewById(R.id.txtIntent);

        if(getIntent().hasExtra("ROOMNAME")){
            Bundle extras = getIntent().getExtras();
            room = extras.getString("ROOMNAME");
            textView.setText("Your "+room+" light is ");
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_white_24dp);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitle(room);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button button = (Button) findViewById(R.id.bntSwitch);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Drawable backgrounds[] = new Drawable[2];
                ImageView image = (ImageView)findViewById(R.id.imgLuz);
                Resources res = getResources();
                backgrounds[0] = res.getDrawable(R.drawable.luzzes);
                backgrounds[1] = res.getDrawable(R.drawable.luzzes);
                TransitionDrawable crossfader = new TransitionDrawable(backgrounds);
                if (image.getVisibility() == INVISIBLE){
                    button.setText("ON");
                    image.setVisibility(View.VISIBLE);
                    crossfader.startTransition(2000);
                    image.setImageDrawable(crossfader);
                    crossfader.startTransition(2000);
                } else {
                    image.setVisibility(INVISIBLE);
                    button.setText("OFF");
                    crossfader.reverseTransition(2000);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
