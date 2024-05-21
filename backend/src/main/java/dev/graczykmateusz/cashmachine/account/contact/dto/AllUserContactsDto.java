package dev.graczykmateusz.cashmachine.account.contact.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import java.util.List;

public record AllUserContactsDto(List<UserContactDto> contacts) implements Result {}
