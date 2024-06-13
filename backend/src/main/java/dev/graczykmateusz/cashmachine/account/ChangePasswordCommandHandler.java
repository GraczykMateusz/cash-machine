package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.command.ChangePassword;
import dev.graczykmateusz.cashmachine.account.exception.AccountNotFoundException;
import dev.graczykmateusz.cashmachine.account.password.PasswordEncoder;
import dev.graczykmateusz.cashmachine.account.password.PasswordVerifier;
import dev.graczykmateusz.cashmachine.account.password.dto.EncodedPassword;
import dev.graczykmateusz.cashmachine.shared.domain.Password;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ChangePasswordCommandHandler implements CommandHandler<ChangePassword> {

  private final AccountQueryRepository queryRepository;
  private final PasswordEncoder passwordEncoder;
  private final PasswordVerifier passwordVerifier;

  @Override
  public void handle(ChangePassword command) {
    Account account =
        queryRepository
            .findById(command.accountId())
            .orElseThrow(() -> new AccountNotFoundException(command.accountId()));
    
    Password oldPassword = new Password(command.oldPassword());
    EncodedPassword encodedOldPassword = passwordEncoder.encodePassword(oldPassword);
    passwordVerifier.verifyPassword(encodedOldPassword, account.getEncodedPassword());
    
    Password newPassword = new Password(command.newPassword());
    EncodedPassword encodedNewPassword = passwordEncoder.encodePassword(newPassword);
    
    account.changePassword(encodedNewPassword);
  }
}
