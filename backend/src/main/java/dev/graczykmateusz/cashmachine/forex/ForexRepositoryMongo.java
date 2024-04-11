package dev.graczykmateusz.cashmachine.forex;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ForexRepositoryMongo extends MongoRepository<ForexData, String> {

}
