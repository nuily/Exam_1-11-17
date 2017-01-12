package nyc.c4q.huilin.picasso_exam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.huilin.picasso_exam.recyclerview.KeyViewHolder;

/**
 * Created by huilin on 1/11/17.
 */
public class DisplayImgActivity extends AppCompatActivity {

    private Intent intent;
    private String imgUrl;
    private ImageView keyImgView;
    private boolean backPressTwiceExit;
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        keyImgView = (ImageView) findViewById(R.id.imgv_key);
        getImgFromIntent();

    }

    private void getImgFromIntent() {
        intent = getIntent();
        imgUrl = MainFragment.JSJROBOTICS + intent.getStringExtra(KeyViewHolder.IMG_URL);
        Picasso.with(getApplicationContext()).load(imgUrl).into(keyImgView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        backPressTwiceExit = false;
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                backPressTwiceExit = false;
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }

    @Override
    public void onBackPressed() {
        if (backPressTwiceExit) {
            super.onBackPressed();
            return;
        }

        this.backPressTwiceExit = true;
        Toast.makeText(getApplicationContext(), "Press once more to see list", Toast.LENGTH_SHORT).show();
        
        mHandler.postDelayed(mRunnable, 2000);
    }
}
