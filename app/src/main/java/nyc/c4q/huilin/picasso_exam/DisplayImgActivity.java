package nyc.c4q.huilin.picasso_exam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import nyc.c4q.huilin.picasso_exam.recyclerview.KeyViewHolder;

/**
 * Created by huilin on 1/11/17.
 */
public class DisplayImgActivity extends AppCompatActivity {

    private Intent intent;
    private String imgUrl;
    private ImageView keyImgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        keyImgView = (ImageView) findViewById(R.id.imgv_key);

        intent = getIntent();
        imgUrl = "http://jsjrobotics.nyc/" + intent.getStringExtra(KeyViewHolder.IMG_URL);
        Picasso.with(getApplicationContext()).load(imgUrl).into(keyImgView);
    }
}
