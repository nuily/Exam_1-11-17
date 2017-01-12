package nyc.c4q.huilin.picasso_exam.model;

import nyc.c4q.huilin.picasso_exam.model.Pojos.KeyboardKeyResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by huilin on 1/11/17.
 */

public interface JsjroboticsService {

    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<KeyboardKeyResponse> getJsjroboticsResponse();
}
