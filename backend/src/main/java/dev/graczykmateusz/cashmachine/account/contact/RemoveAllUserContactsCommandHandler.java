package dev.graczykmateusz.cashmachine.account.contact;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveAllUserContacts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RemoveAllUserContactsCommandHandler implements CommandHandler<RemoveAllUserContacts> {

  private final UserContactRepository repository;

  @Override
  public void handle(RemoveAllUserContacts command) {
    repository.deleteAll();
  }
}
