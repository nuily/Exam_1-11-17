package nyc.c4q.huilin.picasso_exam.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.huilin.picasso_exam.R;
import nyc.c4q.huilin.picasso_exam.model.Pojos.Keys;

import static android.content.ContentValues.TAG;

/**
 * Created by huilin on 1/11/17.
 */
public class KeyboardAdapter extends RecyclerView.Adapter<KeyViewHolder> {
    List<Keys> keyDataList;

    public KeyboardAdapter(List<Keys> keyDataList) {
    this.keyDataList = keyDataList;
        Log.d(TAG, "KeyboardAdapter: " + keyDataList.get(1).getTextColor());
    }

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vh_keys, parent, false);
        return new KeyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(KeyViewHolder holder, int position) {
        Keys key = keyDataList.get(position);
        holder.bind(key);

    }

    @Override
    public int getItemCount() {
        return keyDataList.size();
    }
}
