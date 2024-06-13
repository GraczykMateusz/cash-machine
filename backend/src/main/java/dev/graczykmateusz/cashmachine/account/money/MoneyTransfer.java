package dev.graczykmateusz.cashmachine.account.money;

import dev.graczykmateusz.cashmachine.shared.domain.Money;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "money-transfers")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class MoneyTransfer {

  private @Id String id;
  private String senderAccountId;
  private String receiverAccountId;
  private Money amount;

  MoneyTransfer(String senderAccountId, String receiverAccountId, Money amount) {
    this.senderAccountId = senderAccountId;
    this.receiverAccountId = receiverAccountId;
    this.amount = amount;
  }
}
