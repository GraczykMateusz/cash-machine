package dev.graczykmateusz.cashmachine.account.contact;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.contact.command.AddNewUserContact;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class AddNewUserContactCommandHandler implements CommandHandler<AddNewUserContact> {

  private final UserContactRepository repository;

  @Override
  public void handle(AddNewUserContact command) {
    UserContact userContact =
        new UserContact(command.userId(), command.accountNumber(), command.assignedName());
    repository.save(userContact);
  }
}
