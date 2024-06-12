package dev.graczykmateusz.cashmachine.account.dto;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;

public record AccountDetailsDto(String id, String firstName) implements Result {}
