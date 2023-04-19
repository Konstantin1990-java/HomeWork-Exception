import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "VasiliyAlibabaevich";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        try {
            System.out.println(userVerification(login, password, confirmPassword));
        } catch (WrongLoginException e) {
            System.out.println("Логин должен соответствовать требованиям");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль должен соответствовать требованиям");
        }
    }

    //метод проверки пользовательских данных
    public static boolean userVerification(String login, String password, String confirmPassword) {
        if (login.length() > 20 || conformityCheck(login)) {
            throw new WrongLoginException();
        }
        if (password.length() >= 20 || conformityCheck(password) || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
        return true;
    }

    //метод для проверки логина и пароля на требуемые символы
    public static boolean conformityCheck(String str) {
        char[] arr = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F',
                'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm',
                'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S',
                't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'};
        int count = 0;
        boolean result = false;
        for (int i = 0; i < str.length(); i++) {
            for (char c : arr) {
                if (str.charAt(i) == c) {
                    count++;
                }
            }
        }
        if (count == str.length()) {
            result = true;
        }
        return !result;

    }
}