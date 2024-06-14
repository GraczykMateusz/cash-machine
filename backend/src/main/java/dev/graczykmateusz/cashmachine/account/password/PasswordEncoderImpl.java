package dev.graczykmateusz.cashmachine.account.password;

import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.shared.domain.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.CharBuffer;

@RequiredArgsConstructor
class PasswordEncoderImpl implements PasswordEncoder {

  private final BCryptPasswordEncoder encoder;

  @Override
  public EncodedPassword encodePassword(Password password) {
    CharBuffer passwordBuffer = CharBuffer.wrap(password.value();
    char[] encodePassword = encoder.encode(passwordBuffer).toCharArray();
    return new EncodedPassword(encodePassword);
  }
}
