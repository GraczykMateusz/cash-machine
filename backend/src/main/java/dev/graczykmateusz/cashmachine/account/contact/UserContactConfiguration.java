package dev.graczykmateusz.cashmachine.account.contact;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.contact.command.AddNewUserContact;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveAllUserContacts;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveUserContact;
import dev.graczykmateusz.cashmachine.account.contact.dto.AllUserContactsDto;
import dev.graczykmateusz.cashmachine.account.contact.query.GetAllUserContacts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class UserContactConfiguration {

  @Bean
  CommandHandler<AddNewUserContact> addNewUserContactCommandHandler(
      UserContactRepository repository) {
    return new AddNewUserContactCommandHandler(repository);
  }

  @Bean
  CommandHandler<RemoveAllUserContacts> removeAllUserContactsCommandHandler(
      UserContactRepository repository) {
    return new RemoveAllUserContactsCommandHandler(repository);
  }

  @Bean
  CommandHandler<RemoveUserContact> removeUserContactCommandHandler(
      UserContactRepository repository) {
    return new RemoveUserContactByIdCommandHandler(repository);
  }

  @Bean
  QueryHandler<AllUserContactsDto, GetAllUserContacts> allUserContactsQueryHandler(
      UserContactQueryRepository queryRepository) {
    return new GetAllUserContactsQueryHandler(queryRepository);
  }
}
