package aaagt.springboot.rest.app.model;

public class UserCredentials {

    private final String user;
    private final String password;

    public UserCredentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof UserCredentials &&
                obj.hashCode() == this.hashCode() &&
                user.equals(((UserCredentials) obj).getUser()) &&
                password.equals(((UserCredentials) obj).getPassword());
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
