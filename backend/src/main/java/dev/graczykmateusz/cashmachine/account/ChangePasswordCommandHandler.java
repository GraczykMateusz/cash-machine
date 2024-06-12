package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.cmd.ChangePassword;
import dev.graczykmateusz.cashmachine.account.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ChangePasswordCommandHandler implements CommandHandler<ChangePassword> {
    
    private final AccountRepository repository;
    private final AccountQueryRepository queryRepository;
    
    @Override
    public void handle(ChangePassword command) {
        Password password = new Password(command.password());
        Account account = queryRepository.findById(command.accountId())
                .orElseThrow(() -> new AccountNotFoundException(command.accountId()));
        account.changePassword(password);
        repository.save(account);
    }
}
