package dev.graczykmateusz.cashmachine.api;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandlerExecutor;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandlerExecutor;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveAllUserContacts;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveUserContact;
import dev.graczykmateusz.cashmachine.account.contact.dto.AllUserContactsDto;
import dev.graczykmateusz.cashmachine.account.contact.query.GetAllUserContacts;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/account/{accountId}/contacts")
class ContactsController {

  private final CommandHandlerExecutor commandHandlerExecutor;
  private final QueryHandlerExecutor queryHandlerExecutor;

  @GetMapping
  AllUserContactsDto getAllUserContacts(@PathVariable("accountId") String accountId) {
    return (AllUserContactsDto) queryHandlerExecutor.execute(new GetAllUserContacts(accountId));
  }

  @DeleteMapping("/all")
  void deleteAllUserContacts(RemoveAllUserContacts command) {
    commandHandlerExecutor.execute(command);
  }

  @DeleteMapping("/{userContactId}")
  void deleteUserContactById(@PathVariable("userContactId") String userContactId) {
    commandHandlerExecutor.execute(new RemoveUserContact(userContactId));
  }
}
