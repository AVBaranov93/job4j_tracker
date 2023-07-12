package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                user = users[i];
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean isValid = user.isValid();
        if (!isValid || user.getUsername().length() < 3) {
            throw new UserInvalidException("user invalid");
        }
        return isValid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
