package nyc.c4q.huilin.picasso_exam.model.Pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by huilin on 1/11/17.
 */

public class KeyboardKeyResponse {

    private boolean success;

    @SerializedName("available keys")
    private List<Keys> availableKeys;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Keys> getAvailableKeys() {
        return availableKeys;
    }

    public void setAvailableKeys(List<Keys> availableKeys) {
        this.availableKeys = availableKeys;
    }
}
