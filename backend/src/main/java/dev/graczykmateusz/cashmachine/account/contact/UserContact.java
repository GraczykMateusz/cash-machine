package dev.graczykmateusz.cashmachine.account.contact;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user-contacts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
class UserContact {

  @Id private String id;
  private String userId;
  private String accountNumber;
  private String assignedName;

  UserContact(String userId, String accountNumber, String assignedName) {
    this.userId = userId;
    this.accountNumber = accountNumber;
    this.assignedName = assignedName;
  }
}
