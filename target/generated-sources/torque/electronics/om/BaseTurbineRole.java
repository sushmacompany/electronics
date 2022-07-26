package electronics.om;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * This class was autogenerated by Torque on:
 *
 * [Thu Jul 21 13:38:35 UTC 2022]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to TurbineRole
 */
public abstract class BaseTurbineRole extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1658410715448L;

    /** The Peer class */
    private static final TurbineRolePeer peer =
        new TurbineRolePeer();


    /** The value for the roleId field */
    private int roleId;

    /** The value for the name field */
    private String name;


    /**
     * Get the RoleId
     *
     * @return int
     */
    public int getRoleId()
    {
        return roleId;
    }


    /**
     * Set the value of RoleId
     *
     * @param v new value
     */
    public void setRoleId(int v) throws TorqueException
    {

        if (this.roleId != v)
        {
            this.roleId = v;
            setModified(true);
        }



        // update associated TurbineRolePermission
        if (collTurbineRolePermissions != null)
        {
            for (int i = 0; i < collTurbineRolePermissions.size(); i++)
            {
                ((TurbineRolePermission) collTurbineRolePermissions.get(i))
                        .setRoleId(v);
            }
        }

        // update associated TurbineUserGroupRole
        if (collTurbineUserGroupRoles != null)
        {
            for (int i = 0; i < collTurbineUserGroupRoles.size(); i++)
            {
                ((TurbineUserGroupRole) collTurbineUserGroupRoles.get(i))
                        .setRoleId(v);
            }
        }
    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }


    /**
     * Set the value of Name
     *
     * @param v new value
     */
    public void setName(String v) 
    {

        if (!ObjectUtils.equals(this.name, v))
        {
            this.name = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collTurbineRolePermissions
     */
    protected List<TurbineRolePermission> collTurbineRolePermissions;

    /**
     * Temporary storage of collTurbineRolePermissions to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initTurbineRolePermissions()
    {
        if (collTurbineRolePermissions == null)
        {
            collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
        }
    }


    /**
     * Method called to associate a TurbineRolePermission object to this object
     * through the TurbineRolePermission foreign key attribute
     *
     * @param l TurbineRolePermission
     * @throws TorqueException
     */
    public void addTurbineRolePermission(TurbineRolePermission l) throws TorqueException
    {
        getTurbineRolePermissions().add(l);
        l.setTurbineRole((TurbineRole) this);
    }

    /**
     * Method called to associate a TurbineRolePermission object to this object
     * through the TurbineRolePermission foreign key attribute using connection.
     *
     * @param l TurbineRolePermission
     * @throws TorqueException
     */
    public void addTurbineRolePermission(TurbineRolePermission l, Connection con) throws TorqueException
    {
        getTurbineRolePermissions(con).add(l);
        l.setTurbineRole((TurbineRole) this);
    }

    /**
     * The criteria used to select the current contents of collTurbineRolePermissions
     */
    private Criteria lastTurbineRolePermissionsCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getTurbineRolePermissions(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<TurbineRolePermission> getTurbineRolePermissions()
        throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            collTurbineRolePermissions = getTurbineRolePermissions(new Criteria(10));
        }
        return collTurbineRolePermissions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     * If this TurbineRole is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<TurbineRolePermission> getTurbineRolePermissions(Criteria criteria) throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId() );
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
                if (!lastTurbineRolePermissionsCriteria.equals(criteria))
                {
                    collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria);
                }
            }
        }
        lastTurbineRolePermissionsCriteria = criteria;

        return collTurbineRolePermissions;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getTurbineRolePermissions(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<TurbineRolePermission> getTurbineRolePermissions(Connection con) throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            collTurbineRolePermissions = getTurbineRolePermissions(new Criteria(10), con);
        }
        return collTurbineRolePermissions;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     * If this TurbineRole is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<TurbineRolePermission> getTurbineRolePermissions(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                 criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
                 collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
                 if (!lastTurbineRolePermissionsCriteria.equals(criteria))
                 {
                     collTurbineRolePermissions = TurbineRolePermissionPeer.doSelect(criteria, con);
                 }
             }
         }
         lastTurbineRolePermissionsCriteria = criteria;

         return collTurbineRolePermissions;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole is new, it will return
     * an empty collection; or if this TurbineRole has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbineRole.
     */
    protected List<TurbineRolePermission> getTurbineRolePermissionsJoinTurbineRole(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbineRole(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
            if (!lastTurbineRolePermissionsCriteria.equals(criteria))
            {
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbineRole(criteria);
            }
        }
        lastTurbineRolePermissionsCriteria = criteria;

        return collTurbineRolePermissions;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole is new, it will return
     * an empty collection; or if this TurbineRole has previously
     * been saved, it will retrieve related TurbineRolePermissions from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbineRole.
     */
    protected List<TurbineRolePermission> getTurbineRolePermissionsJoinTurbinePermission(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineRolePermissions == null)
        {
            if (isNew())
            {
               collTurbineRolePermissions = new ArrayList<TurbineRolePermission>();
            }
            else
            {
                criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbinePermission(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineRolePermissionPeer.ROLE_ID, getRoleId());
            if (!lastTurbineRolePermissionsCriteria.equals(criteria))
            {
                collTurbineRolePermissions = TurbineRolePermissionPeer.doSelectJoinTurbinePermission(criteria);
            }
        }
        lastTurbineRolePermissionsCriteria = criteria;

        return collTurbineRolePermissions;
    }





    /**
     * Collection to store aggregation of collTurbineUserGroupRoles
     */
    protected List<TurbineUserGroupRole> collTurbineUserGroupRoles;

    /**
     * Temporary storage of collTurbineUserGroupRoles to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initTurbineUserGroupRoles()
    {
        if (collTurbineUserGroupRoles == null)
        {
            collTurbineUserGroupRoles = new ArrayList<TurbineUserGroupRole>();
        }
    }


    /**
     * Method called to associate a TurbineUserGroupRole object to this object
     * through the TurbineUserGroupRole foreign key attribute
     *
     * @param l TurbineUserGroupRole
     * @throws TorqueException
     */
    public void addTurbineUserGroupRole(TurbineUserGroupRole l) throws TorqueException
    {
        getTurbineUserGroupRoles().add(l);
        l.setTurbineRole((TurbineRole) this);
    }

    /**
     * Method called to associate a TurbineUserGroupRole object to this object
     * through the TurbineUserGroupRole foreign key attribute using connection.
     *
     * @param l TurbineUserGroupRole
     * @throws TorqueException
     */
    public void addTurbineUserGroupRole(TurbineUserGroupRole l, Connection con) throws TorqueException
    {
        getTurbineUserGroupRoles(con).add(l);
        l.setTurbineRole((TurbineRole) this);
    }

    /**
     * The criteria used to select the current contents of collTurbineUserGroupRoles
     */
    private Criteria lastTurbineUserGroupRolesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getTurbineUserGroupRoles(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<TurbineUserGroupRole> getTurbineUserGroupRoles()
        throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            collTurbineUserGroupRoles = getTurbineUserGroupRoles(new Criteria(10));
        }
        return collTurbineUserGroupRoles;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole has previously
     * been saved, it will retrieve related TurbineUserGroupRoles from storage.
     * If this TurbineRole is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<TurbineUserGroupRole> getTurbineUserGroupRoles(Criteria criteria) throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            if (isNew())
            {
               collTurbineUserGroupRoles = new ArrayList<TurbineUserGroupRole>();
            }
            else
            {
                criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId() );
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
                if (!lastTurbineUserGroupRolesCriteria.equals(criteria))
                {
                    collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelect(criteria);
                }
            }
        }
        lastTurbineUserGroupRolesCriteria = criteria;

        return collTurbineUserGroupRoles;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getTurbineUserGroupRoles(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<TurbineUserGroupRole> getTurbineUserGroupRoles(Connection con) throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            collTurbineUserGroupRoles = getTurbineUserGroupRoles(new Criteria(10), con);
        }
        return collTurbineUserGroupRoles;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole has previously
     * been saved, it will retrieve related TurbineUserGroupRoles from storage.
     * If this TurbineRole is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<TurbineUserGroupRole> getTurbineUserGroupRoles(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            if (isNew())
            {
               collTurbineUserGroupRoles = new ArrayList<TurbineUserGroupRole>();
            }
            else
            {
                 criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
                 collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
                 if (!lastTurbineUserGroupRolesCriteria.equals(criteria))
                 {
                     collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelect(criteria, con);
                 }
             }
         }
         lastTurbineUserGroupRolesCriteria = criteria;

         return collTurbineUserGroupRoles;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole is new, it will return
     * an empty collection; or if this TurbineRole has previously
     * been saved, it will retrieve related TurbineUserGroupRoles from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbineRole.
     */
    protected List<TurbineUserGroupRole> getTurbineUserGroupRolesJoinTurbineUser(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            if (isNew())
            {
               collTurbineUserGroupRoles = new ArrayList<TurbineUserGroupRole>();
            }
            else
            {
                criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelectJoinTurbineUser(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
            if (!lastTurbineUserGroupRolesCriteria.equals(criteria))
            {
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelectJoinTurbineUser(criteria);
            }
        }
        lastTurbineUserGroupRolesCriteria = criteria;

        return collTurbineUserGroupRoles;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole is new, it will return
     * an empty collection; or if this TurbineRole has previously
     * been saved, it will retrieve related TurbineUserGroupRoles from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbineRole.
     */
    protected List<TurbineUserGroupRole> getTurbineUserGroupRolesJoinTurbineGroup(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            if (isNew())
            {
               collTurbineUserGroupRoles = new ArrayList<TurbineUserGroupRole>();
            }
            else
            {
                criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelectJoinTurbineGroup(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
            if (!lastTurbineUserGroupRolesCriteria.equals(criteria))
            {
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelectJoinTurbineGroup(criteria);
            }
        }
        lastTurbineUserGroupRolesCriteria = criteria;

        return collTurbineUserGroupRoles;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this TurbineRole is new, it will return
     * an empty collection; or if this TurbineRole has previously
     * been saved, it will retrieve related TurbineUserGroupRoles from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in TurbineRole.
     */
    protected List<TurbineUserGroupRole> getTurbineUserGroupRolesJoinTurbineRole(Criteria criteria)
        throws TorqueException
    {
        if (collTurbineUserGroupRoles == null)
        {
            if (isNew())
            {
               collTurbineUserGroupRoles = new ArrayList<TurbineUserGroupRole>();
            }
            else
            {
                criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelectJoinTurbineRole(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(TurbineUserGroupRolePeer.ROLE_ID, getRoleId());
            if (!lastTurbineUserGroupRolesCriteria.equals(criteria))
            {
                collTurbineUserGroupRoles = TurbineUserGroupRolePeer.doSelectJoinTurbineRole(criteria);
            }
        }
        lastTurbineUserGroupRolesCriteria = criteria;

        return collTurbineUserGroupRoles;
    }



        
    private static List<String> fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List<String> getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList<String>();
            fieldNames.add("RoleId");
            fieldNames.add("Name");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("RoleId"))
        {
            return new Integer(getRoleId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("RoleId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRoleId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(TurbineRolePeer.ROLE_ID))
        {
            return new Integer(getRoleId());
        }
        if (name.equals(TurbineRolePeer.ROLE_NAME))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (TurbineRolePeer.ROLE_ID.equals(name))
        {
            return setByName("RoleId", value);
        }
      if (TurbineRolePeer.ROLE_NAME.equals(name))
        {
            return setByName("Name", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getRoleId());
        }
        if (pos == 1)
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("RoleId", value);
        }
    if (position == 1)
        {
            return setByName("Name", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws TorqueException
     */
    public void save() throws TorqueException
    {
        save(TurbineRolePeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    TurbineRolePeer.doInsert((TurbineRole) this, con);
                    setNew(false);
                }
                else
                {
                    TurbineRolePeer.doUpdate((TurbineRole) this, con);
                }
            }


            if (collTurbineRolePermissions != null)
            {
                for (int i = 0; i < collTurbineRolePermissions.size(); i++)
                {
                    ((TurbineRolePermission) collTurbineRolePermissions.get(i)).save(con);
                }
            }

            if (collTurbineUserGroupRoles != null)
            {
                for (int i = 0; i < collTurbineUserGroupRoles.size(); i++)
                {
                    ((TurbineUserGroupRole) collTurbineUserGroupRoles.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key roleId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setRoleId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setRoleId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getRoleId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public TurbineRole copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public TurbineRole copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public TurbineRole copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new TurbineRole(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public TurbineRole copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new TurbineRole(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected TurbineRole copyInto(TurbineRole copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected TurbineRole copyInto(TurbineRole copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected TurbineRole copyInto(TurbineRole copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setRoleId(roleId);
        copyObj.setName(name);

        copyObj.setRoleId( 0);

        if (deepcopy)
        {


        List<TurbineRolePermission> vTurbineRolePermissions = getTurbineRolePermissions();
        if (vTurbineRolePermissions != null)
        {
            for (int i = 0; i < vTurbineRolePermissions.size(); i++)
            {
                TurbineRolePermission obj =  vTurbineRolePermissions.get(i);
                copyObj.addTurbineRolePermission(obj.copy());
            }
        }
        else
        {
            copyObj.collTurbineRolePermissions = null;
        }


        List<TurbineUserGroupRole> vTurbineUserGroupRoles = getTurbineUserGroupRoles();
        if (vTurbineUserGroupRoles != null)
        {
            for (int i = 0; i < vTurbineUserGroupRoles.size(); i++)
            {
                TurbineUserGroupRole obj =  vTurbineUserGroupRoles.get(i);
                copyObj.addTurbineUserGroupRole(obj.copy());
            }
        }
        else
        {
            copyObj.collTurbineUserGroupRoles = null;
        }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected TurbineRole copyInto(TurbineRole copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setRoleId(roleId);
        copyObj.setName(name);

        copyObj.setRoleId( 0);

        if (deepcopy)
        {


        List<TurbineRolePermission> vTurbineRolePermissions = getTurbineRolePermissions(con);
        if (vTurbineRolePermissions != null)
        {
            for (int i = 0; i < vTurbineRolePermissions.size(); i++)
            {
                TurbineRolePermission obj =  vTurbineRolePermissions.get(i);
                copyObj.addTurbineRolePermission(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collTurbineRolePermissions = null;
        }


        List<TurbineUserGroupRole> vTurbineUserGroupRoles = getTurbineUserGroupRoles(con);
        if (vTurbineUserGroupRoles != null)
        {
            for (int i = 0; i < vTurbineUserGroupRoles.size(); i++)
            {
                TurbineUserGroupRole obj =  vTurbineUserGroupRoles.get(i);
                copyObj.addTurbineUserGroupRole(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collTurbineUserGroupRoles = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public TurbineRolePeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return TurbineRolePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("TurbineRole:\n");
        str.append("RoleId = ")
           .append(getRoleId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        return(str.toString());
    }
}
