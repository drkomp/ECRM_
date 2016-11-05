package com.easycrm.abstractdao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by drkomp on 03.10.2016.
 */
public interface GenericDao<Entity> {
     Entity getItById( long id) throws SQLException;

     List findItByExample(Entity exampleInstance, String[] excludeProperty);

    List findItByField(String fieldName, String fieldValue);

   // void addIt(Entity entity)throws SQLException;
     Entity mergeIt(Entity entity)throws SQLException;
     void removeIt(Entity entity) throws SQLException;
     void persistIt(Entity entity) throws SQLException;
}
