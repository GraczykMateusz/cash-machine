package dev.graczykmateusz.cashmachine.forex;

interface ForexRepository {
    
    <S extends ForexData> S save(S entity);
}
