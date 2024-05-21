package dev.graczykmateusz.cashmachine.account.contact;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveUserContact;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RemoveUserContactByIdCommandHandler implements CommandHandler<RemoveUserContact> {

  private final UserContactRepository repository;

  @Override
  public void handle(RemoveUserContact command) {
    repository.deleteById(command.id());
  }
}
