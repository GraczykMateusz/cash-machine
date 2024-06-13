package dev.graczykmateusz.cashmachine.account.password;

import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;

public interface PasswordVerifier {

  boolean verifyPassword(EncodedPassword ep1, EncodedPassword ep2);
}
