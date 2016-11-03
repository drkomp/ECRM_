package com.easycrm.abstractdao;

import java.sql.SQLException;

/**
 * Created by drkomp on 03.10.2016.
 */
public interface AbstractGenDao<Entity> {
     Entity getItById(Class<Entity> clazz, long id) throws SQLException;
     void addIt(Entity entity)throws SQLException;
     void updateIt(Entity entity)throws SQLException;
     void deleteIt(Entity entity) throws SQLException;
     void persistIt(Entity entity) throws SQLException;
}
