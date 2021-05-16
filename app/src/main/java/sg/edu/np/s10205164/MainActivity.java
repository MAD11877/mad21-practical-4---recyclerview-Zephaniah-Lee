package sg.edu.np.s10205164;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;

    public void SetFollowBtnTxt(User user, Button FollowBtn){

        if (user.isFollowed()){
            FollowBtn.setText("Unfollow");
            Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
        }
        else{
            FollowBtn.setText("Follow");
            Toast.makeText(getApplicationContext(),"Unfollowed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("debug","create");

        Intent in = getIntent();
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        int id = in.getIntExtra("userId", 0);
        Boolean isFollowed = in.getBooleanExtra("userFollowed", false);

        textView.setText(in.getStringExtra("userName"));
        textView2.setText(in.getStringExtra("userDescription"));

        User u = new User("temp","temp",0, isFollowed);
        Button FollowBtn = findViewById(R.id.follow);
        SetFollowBtnTxt(u,FollowBtn);

        FollowBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                u.ToggleFollow();
                SetFollowBtnTxt(u,FollowBtn);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("debug","start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("debug","resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("debug","pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("debug","stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("debug","destroy");
    }
}