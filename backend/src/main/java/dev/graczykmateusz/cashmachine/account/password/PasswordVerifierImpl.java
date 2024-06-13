package dev.graczykmateusz.cashmachine.account.password;

import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
class PasswordVerifierImpl implements PasswordVerifier {

  private final BCryptPasswordEncoder encoder;

  @Override
  public boolean verifyPassword(EncodedPassword ep1, EncodedPassword ep2) {
    return encoder.matches(String.valueOf(ep1.value()), String.valueOf(ep2.value()));
  }
}
