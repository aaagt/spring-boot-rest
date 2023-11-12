package aaagt.springboot.rest.app.model;

public class User {

    //@NotBlank(message = "User name is empty")
    private final String user;
    //@NotBlank(message = "Password is empty")
    private final String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof User &&
                obj.hashCode() == this.hashCode() &&
                user.equals(((User) obj).getUser()) &&
                password.equals(((User) obj).getPassword());
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
