package dev.graczykmateusz.cashmachine.forex;

import java.util.ArrayList;
import java.util.List;

class ForexRepositoryInMemory implements ForexRepository {
    
    private final List<ForexData> data = new ArrayList<>();
    
    @Override
    public <S extends ForexData> S save(S entity) {
        throw new UnsupportedOperationException("Method not implemented!");
    }
}
