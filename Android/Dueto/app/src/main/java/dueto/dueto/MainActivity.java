package dueto.dueto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    private Button LogIn;
    private Button SignIn;
    private Button Notifications;
    private int bVisibility = View.INVISIBLE;
    private int menuButtonRotation = 45;
//    private Display display = getWindowManager().getDefaultDisplay();
//    private DisplayMetrics displayMetrics = new DisplayMetrics();
    private boolean scrollable = true; //Scroll always
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /*TableLayout t1 = findViewById(R.id.homeTable);
        TableRow row = new TableRow(this);
        t1.addView(row);*/

//        display.getMetrics(displayMetrics);
//
//        int height = displayMetrics.heightPixels;
//        int width = displayMetrics.widthPixels;
//        int dens = displayMetrics.densityDpi;
//
        //Defining login buttons
        LogIn = (Button)findViewById(R.id.logButt); //the sign-in + log-in buttons on the Main page
        SignIn = (Button)findViewById(R.id.signButt);
        Notifications = (Button)findViewById(R.id.tabButt);

        LogIn.setOnClickListener(new View.OnClickListener() { //calls onClick(default name) through ClickListener which takes you to LoginActivity
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
            }
        });
        //------------------------------------------------------------------------------------------

        Notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TimelineActivity.class));
            }
        });

        //Defining buttons to use them later
        final FloatingActionButton
                menuButton = findViewById(R.id.menuButton),
                cameraButton  = findViewById(R.id.cameraButton),
                coopButton = findViewById(R.id.coopButton),
                discoverButton = findViewById(R.id.discoverButton),
                messagesButton = findViewById(R.id.messagesButton),
                profileButton = findViewById(R.id.profileButton),
                homeButton = findViewById(R.id.homeButton);

        final RelativeLayout constr = findViewById(R.id.relLayout);

        final ScrollView sView = findViewById(R.id.sView);

        //Setting button visibility to invisible
        constr.setVisibility(bVisibility);
        menuButton.setRotation(menuButtonRotation);
        menuButtonRotation=0;
        bVisibility = View.VISIBLE;

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuButton.setRotation(menuButtonRotation);
                constr.setVisibility(bVisibility);
                bVisibility = bVisibility != 0 ? 0:4;
                menuButtonRotation = menuButtonRotation != 45 ? 45: 0;
                if(scrollable) {
                    sView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }
                else
                {
                    sView.setOnTouchListener(null);
                }

                scrollable = !scrollable;
            }
        });
    }
}
