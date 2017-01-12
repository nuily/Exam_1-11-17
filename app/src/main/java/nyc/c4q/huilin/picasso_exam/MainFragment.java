package nyc.c4q.huilin.picasso_exam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.huilin.picasso_exam.model.JsjroboticsService;
import nyc.c4q.huilin.picasso_exam.model.Pojos.KeyboardKeyResponse;
import nyc.c4q.huilin.picasso_exam.model.Pojos.Keys;
import nyc.c4q.huilin.picasso_exam.recyclerview.KeyboardAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by huilin on 1/11/17.
 */

public class MainFragment extends Fragment{

    private List<Keys> keyDataList;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_keys, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRVwithKeysList(view);
    }

    private void initRv(View view) {
        rv = (RecyclerView) view.findViewById(R.id.fragment_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(new KeyboardAdapter(keyDataList));
        Log.d(TAG, "onResponse: " + keyDataList.get(0).getName());

    }

    private void initRVwithKeysList(final View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsjroboticsService service = retrofit.create(JsjroboticsService.class);
        Call<KeyboardKeyResponse> call = service.getJsjroboticsResponse();
        call.enqueue(new Callback<KeyboardKeyResponse>() {
            @Override
            public void onResponse(Call<KeyboardKeyResponse> call, Response<KeyboardKeyResponse> response) {

                KeyboardKeyResponse keyResponse = response.body();
                keyDataList = keyResponse.getAvailableKeys();
                initRv(view);
            }

            @Override
            public void onFailure(Call<KeyboardKeyResponse> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
