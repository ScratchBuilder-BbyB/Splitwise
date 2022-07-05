package dao;

import java.util.List;

public interface Repository <T, ID, Filter>{
  T save(T t);
  T getById(ID id);
  T update(T t);
  List<T> getAllByFilter(Filter filter);
}
