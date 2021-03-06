package sample.database;

public class User{
    private String login;
    private String password;
    private boolean active;
    private String role;
    private String email;

    private static User currentUser = null;

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public User(String login, String name) {
        this.login = login;
        this.password = name;
    }

    public User(String login, String name, String email) {
        this.login = login;
        this.password = name;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
