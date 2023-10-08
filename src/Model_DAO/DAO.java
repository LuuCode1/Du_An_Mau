/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_DAO;

import java.util.List;

/**
 *
 * @author Asus
 */
public abstract class DAO<E,K> {
        abstract public int insert(E entity);
        abstract public E checkMa(K key);
        abstract public int update(E entity, K key);
        abstract public int delete(K key);
        abstract public List<E> selectAll();
        abstract public void SelectById(K key);
        abstract protected void selectBySql(String sql,Object...args);
        
}
