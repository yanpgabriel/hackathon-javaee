package com.stefanini.util;

public class CheckPasswordValidator{
    public static final String PASSWORD_VALIDATOR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?]).+$";
    public static final String SENHA_FORA_DO_PADRAO = "A senha deve possuir: um caractere maiuscula, um caractere minusculo, uma caractere especial e um caractere numérico";

}