package com.persona.demo_personas.Utils;

import java.util.regex.Pattern;

public class Utils {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@dominio\\.cl$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d\\d)[A-Za-z\\d]+$";

    public static boolean esCorreoValido(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean validaPassword(String contraseña) {
        if (contraseña == null || contraseña.isEmpty()) {
            return false;
        }
        return Pattern.matches(PASSWORD_REGEX, contraseña);
    }
}
