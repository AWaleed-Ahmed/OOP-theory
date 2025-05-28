package backend.models;

public abstract class AuthenticatorBase {
    public abstract void signup(User user);
    public abstract void loadUsersFromFile();
    public abstract boolean authenticate(User user);
}
