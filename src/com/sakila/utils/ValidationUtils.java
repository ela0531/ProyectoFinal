package com.sakila.utils;

import java.util.regex.Pattern;

/**
 * Utilidades de validación con expresiones regulares
 */
public class ValidationUtils {
    public static boolean isValidPhone(String phone) {
        return Pattern.matches("\\d{3}-\\d{3}-\\d{4}", phone);
    }
    public static boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email);
    }
    public static boolean isValidDate(String date) {
        return Pattern.matches("\\d{4}-\\d{2}-\\d{2}", date);
    }
    public static boolean isValidSSN(String ssn) {
        return Pattern.matches("\\d{3}-\\d{2}-\\d{4}", ssn);
    }
}
