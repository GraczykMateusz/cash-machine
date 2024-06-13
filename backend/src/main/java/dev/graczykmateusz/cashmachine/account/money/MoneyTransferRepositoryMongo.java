package dev.graczykmateusz.cashmachine.account.money;

import org.springframework.data.mongodb.repository.MongoRepository;

interface MoneyTransferRepositoryMongo
    extends MongoRepository<MoneyTransfer, String>, MoneyTransferRepository {}
