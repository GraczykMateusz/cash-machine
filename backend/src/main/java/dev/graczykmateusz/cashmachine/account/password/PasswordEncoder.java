package dev.graczykmateusz.cashmachine.account.password;

import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.shared.domain.Password;

public interface PasswordEncoder {

  EncodedPassword encodePassword(Password password );
}
