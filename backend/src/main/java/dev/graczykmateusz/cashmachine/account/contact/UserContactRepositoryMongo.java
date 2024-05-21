package dev.graczykmateusz.cashmachine.account.contact;

import org.springframework.data.mongodb.repository.MongoRepository;

interface UserContactRepositoryMongo
    extends MongoRepository<UserContact, String>,
        UserContactQueryRepository,
        UserContactRepository {}
