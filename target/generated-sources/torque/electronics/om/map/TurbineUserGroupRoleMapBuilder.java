package electronics.om.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.InheritanceMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Thu Jul 21 13:38:35 UTC 2022]
  *
  */
public class TurbineUserGroupRoleMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "electronics.om.map.TurbineUserGroupRoleMapBuilder";

    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public synchronized void doBuild() throws TorqueException
    {
        if ( isBuilt() ) {
            return;
        }
        dbMap = Torque.getDatabaseMap("turbine");

        dbMap.addTable("TURBINE_USER_GROUP_ROLE");
        TableMap tMap = dbMap.getTable("TURBINE_USER_GROUP_ROLE");
        tMap.setJavaName("TurbineUserGroupRole");
        tMap.setOMClass( electronics.om.TurbineUserGroupRole.class );
        tMap.setPeerClass( electronics.om.TurbineUserGroupRolePeer.class );
        tMap.setPrimaryKeyMethod("none");

        ColumnMap cMap = null;


  // ------------- Column: USER_ID --------------------
        cMap = new ColumnMap( "USER_ID", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "UserId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setInheritance("false");
        cMap.setForeignKey("TURBINE_USER", "USER_ID");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: GROUP_ID --------------------
        cMap = new ColumnMap( "GROUP_ID", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "GroupId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setInheritance("false");
        cMap.setForeignKey("TURBINE_GROUP", "GROUP_ID");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: ROLE_ID --------------------
        cMap = new ColumnMap( "ROLE_ID", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "RoleId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setInheritance("false");
        cMap.setForeignKey("TURBINE_ROLE", "ROLE_ID");
        cMap.setPosition(3);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
