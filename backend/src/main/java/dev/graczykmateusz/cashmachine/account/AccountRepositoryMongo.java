package dev.graczykmateusz.cashmachine.account;

import org.springframework.data.mongodb.repository.MongoRepository;

interface AccountRepositoryMongo
    extends MongoRepository<Account, String>,
        AccountRepository,
        AccountQueryRepository {}
