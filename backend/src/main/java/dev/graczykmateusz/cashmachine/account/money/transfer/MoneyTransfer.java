package dev.graczykmateusz.cashmachine.account.money.transfer;

import dev.graczykmateusz.cashmachine.shared.domain.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "money-transfers")
class MoneyTransfer {

  @Id String id;
  String senderAccountId;
  String receiverAccountId;
  Money amount;

  MoneyTransfer(String senderAccountId, String receiverAccountId, Money amount) {
    this.senderAccountId = senderAccountId;
    this.receiverAccountId = receiverAccountId;
    this.amount = amount;
  }
}
