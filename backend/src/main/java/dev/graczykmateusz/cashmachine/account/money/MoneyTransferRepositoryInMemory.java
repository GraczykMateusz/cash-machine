package dev.graczykmateusz.cashmachine.account.money;

import java.util.ArrayList;
import java.util.List;

class MoneyTransferRepositoryInMemory implements MoneyTransferRepository {

  private final List<MoneyTransfer> data = new ArrayList<>();

  @Override
  public <S extends MoneyTransfer> S save(S entity) {
    data.add(entity);
    return entity;
  }

  @Override
  public void deleteAll() {
    data.clear();
  }

  @Override
  public List<MoneyTransfer> findBySenderAccountId(String senderAccountId) {
    return data.stream()
        .filter(moneyTransfer -> moneyTransfer.getSenderAccountId().equals(senderAccountId))
        .toList();
  }

  @Override
  public List<MoneyTransfer> findByReceiverAccountId(String receiverAccountId) {
    return data.stream()
        .filter(moneyTransfer -> moneyTransfer.getReceiverAccountId().equals(receiverAccountId))
        .toList();
  }
}
