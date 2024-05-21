package dev.graczykmateusz.cashmachine.account.contact;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.contact.dto.AllUserContactsDto;
import dev.graczykmateusz.cashmachine.account.contact.dto.UserContactDto;
import dev.graczykmateusz.cashmachine.account.contact.query.GetAllUserContacts;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAllUserContactsQueryHandler
    implements QueryHandler<AllUserContactsDto, GetAllUserContacts> {

  private final UserContactQueryRepository queryRepository;

  @Override
  public AllUserContactsDto handle(GetAllUserContacts query) {
    List<UserContact> userContacts = queryRepository.findByUserId(query.userId());
    List<UserContactDto> userContactDtos =
        userContacts.stream().map(UserContactMapper::toDto).toList();
    return new AllUserContactsDto(userContactDtos);
  }
}
