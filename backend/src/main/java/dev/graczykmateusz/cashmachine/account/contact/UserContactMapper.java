package dev.graczykmateusz.cashmachine.account.contact;

import dev.graczykmateusz.cashmachine.account.contact.dto.UserContactDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class UserContactMapper {

  static UserContactDto toDto(UserContact userContact) {
    return new UserContactDto(
        userContact.getId(), userContact.getAccountNumber(), userContact.getAssignedName());
  }
}
