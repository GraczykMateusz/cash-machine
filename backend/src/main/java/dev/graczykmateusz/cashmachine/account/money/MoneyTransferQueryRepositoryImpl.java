package dev.graczykmateusz.cashmachine.account.money;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class MoneyTransferQueryRepositoryImpl implements MoneyTransferQueryRepository {

  private final MoneyTransferRepository repository;

  @Override
  public MoneyTransfers findBySenderAccountId(String senderAccountId) {
    List<MoneyTransfer> byReceiverAccountId = repository.findBySenderAccountId(senderAccountId);
    return new MoneyTransfers(byReceiverAccountId);
  }

  @Override
  public MoneyTransfers findByReceiverAccountId(String receiverAccountId) {
    List<MoneyTransfer> byReceiverAccountId = repository.findByReceiverAccountId(receiverAccountId);
    return new MoneyTransfers(byReceiverAccountId);
  }
}
