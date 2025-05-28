package backend.services;

public class Authenticator extends AuthenticatorService {
    @Override
    public boolean login(String username, String password) {
        return findUserByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
