package io.io.Exception;

public class ExistingUsernameException extends Exception{
    private String username;

    public ExistingUsernameException(String username){
        this.username=username;
    }

    public String getUsername() {
        return username;
    }
}
