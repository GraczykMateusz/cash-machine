package dev.graczykmateusz.cashmachine.account.money;

interface MoneyTransferQueryRepository {

  MoneyTransfers findBySenderAccountId(String senderAccountId);

  MoneyTransfers findByReceiverAccountId(String receiverAccountId);
}
