package ecomerce.shopping.interfaces;

import java.util.List;

public interface GenericOperations<T, N>{

    public T create(T entity);

    public T read(N id);

    public List<T> readALL();

    public T updatePart(N id, T entity);

    public T updateall(N id, T entity);

    public void delete(N id);
}
