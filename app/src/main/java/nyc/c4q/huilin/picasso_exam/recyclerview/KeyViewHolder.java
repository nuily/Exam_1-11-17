package nyc.c4q.huilin.picasso_exam.recyclerview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.huilin.picasso_exam.DisplayImgActivity;
import nyc.c4q.huilin.picasso_exam.R;
import nyc.c4q.huilin.picasso_exam.model.Pojos.Keys;

/**
 * Created by huilin on 1/11/17.
 */
public class KeyViewHolder extends RecyclerView.ViewHolder {
    public static final String IMG_URL = "nyc.c4q.huilin.picasso_exam.recyclerview.IMG_URL" ;
    private View mView;
    private TextView keyName;
    private String textColor;
    private String imgUrl;

    public KeyViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        keyName = (TextView) mView.findViewById(R.id.tv_keyName);
    }

    public void bind(final Keys key) {
        if (key != null) {
            keyName.setText(key.getName());
            textColor = key.getTextColor();
            keyName.setTextColor(Color.parseColor(textColor));

            keyName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mView.getContext(), DisplayImgActivity.class);
                    imgUrl = key.getUrl();
                    intent.putExtra(IMG_URL, imgUrl);
                    mView.getContext().startActivity(intent);
                }
            });
        }
    }
}
