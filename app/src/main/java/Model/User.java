package Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
