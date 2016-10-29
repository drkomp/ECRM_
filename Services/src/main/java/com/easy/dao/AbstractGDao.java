package com.easy.dao;

import java.sql.SQLException;

/**
 * Created by drkomp on 03.10.2016.
 */
public interface AbstractGDao<Entity> {
    public Entity getItById(Class<Entity> clazz, long id) throws SQLException;
    public void addIt(Entity entity)throws SQLException;
    public void updateIt(Entity entity)throws SQLException;
    public void deleteIt(Entity entity) throws SQLException;
    public void persistIt(Entity entity) throws SQLException;
}
