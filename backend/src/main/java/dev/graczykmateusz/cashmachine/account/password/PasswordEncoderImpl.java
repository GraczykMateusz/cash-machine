package dev.graczykmateusz.cashmachine.account.password;

import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.shared.domain.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
class PasswordEncoderImpl implements PasswordEncoder {

  private final BCryptPasswordEncoder encoder;

  @Override
  public EncodedPassword encodePassword(Password password) {
    char[] encodePassword = encoder.encode(String.valueOf(password.value())).toCharArray();
    return new EncodedPassword(encodePassword);
  }
}
