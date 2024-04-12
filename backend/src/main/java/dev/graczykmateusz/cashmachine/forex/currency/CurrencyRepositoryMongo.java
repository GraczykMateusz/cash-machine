package dev.graczykmateusz.cashmachine.forex.currency;

import org.springframework.data.mongodb.repository.MongoRepository;

interface CurrencyRepositoryMongo extends MongoRepository<CurrencyDetails, String> {

}
