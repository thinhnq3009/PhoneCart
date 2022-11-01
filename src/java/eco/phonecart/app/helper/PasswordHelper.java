package eco.phonecart.app.helper;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHelper {
    public static String hash(String password) {
        return DigestUtils.md5Hex(password).toUpperCase();
    }

    public static boolean verifyPassword(String password, String hash) {
        return hash.equals(hash(password));
    }
}
