package dev.graczykmateusz.cashmachine.account.money;

import java.util.List;

interface MoneyTransferRepository {

  <S extends MoneyTransfer> S save(S entity);

  void deleteAll();

  List<MoneyTransfer> findBySenderAccountId(String senderAccountId);

  List<MoneyTransfer> findByReceiverAccountId(String receiverAccountId);
}
