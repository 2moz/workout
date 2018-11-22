package com._2mozz.wtool.payload;

public class JWTLoginSucessResponse {
    private boolean success;
    private String token;

    public JWTLoginSucessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSucess() {
        return success;
    }

    public void setSucess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "JWTLoginSucessResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
