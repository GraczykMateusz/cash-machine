package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.dto.AccountDetailsDto;
import dev.graczykmateusz.cashmachine.account.exception.AccountNotFoundException;
import dev.graczykmateusz.cashmachine.account.query.GetAccountDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAccountDetailsQueryHandler implements QueryHandler<AccountDetailsDto, GetAccountDetails> {

  private final AccountQueryRepository repository;

  @Override
  public AccountDetailsDto handle(GetAccountDetails query) {
    Account account =
        repository
            .findById(query.accountId())
            .orElseThrow(() -> new AccountNotFoundException(query.accountId()));
    return AccountMapper.toDto(account);
  }
}
