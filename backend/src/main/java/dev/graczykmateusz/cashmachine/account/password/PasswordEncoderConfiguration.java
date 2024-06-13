package dev.graczykmateusz.cashmachine.account.password;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
class PasswordEncoderConfiguration {

  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  @Bean("passwordEncoder")
  PasswordEncoder passwordEncoder() {
    return new PasswordEncoderImpl(bCryptPasswordEncoder);
  }

  @Bean("passwordVerifier")
  PasswordVerifier passwordVerifier() {
    return new PasswordVerifierImpl(bCryptPasswordEncoder);
  }
}
