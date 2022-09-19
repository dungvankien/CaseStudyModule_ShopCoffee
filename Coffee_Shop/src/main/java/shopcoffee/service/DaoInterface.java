package shopcoffee.service;

import java.util.ArrayList;

public interface DaoInterface <T> {
    public int insert(T t);

    public int update(T t);

    public int delete(int id);

    public ArrayList<T> selectAll();

    public T selectById(int id);

    public ArrayList<T> selectByCondition(String condition);
}
