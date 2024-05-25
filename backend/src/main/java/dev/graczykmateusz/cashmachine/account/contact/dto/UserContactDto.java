package dev.graczykmateusz.cashmachine.account.contact.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;

public record UserContactDto(String id, String accountNumber, String assignedName)
    implements Result {}
