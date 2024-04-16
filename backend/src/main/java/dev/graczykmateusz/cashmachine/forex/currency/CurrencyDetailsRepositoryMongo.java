package dev.graczykmateusz.cashmachine.forex.currency;

import org.springframework.data.mongodb.repository.MongoRepository;

interface CurrencyDetailsRepositoryMongo
    extends MongoRepository<CurrencyDetails, String>,
        CurrencyDetailsRepository,
        CurrencyDetailsQueryRepository {}
