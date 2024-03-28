package dev.graczykmateusz.cashmachine.abstraction.query;

import java.lang.reflect.ParameterizedType;

public interface QueryHandler<R extends Result, Q extends Query> {

  default Class<Q> handlingCommandClass() {
    //noinspection unchecked
    return (Class<Q>)
        ((ParameterizedType) this.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
  }

  R handle(Q query);
}
