package com.bnp.usertype


import org.grails.web.json.JSONObject
import org.hibernate.HibernateException
import org.hibernate.engine.spi.SessionImplementor
import org.hibernate.type.StandardBasicTypes
import org.hibernate.usertype.EnhancedUserType

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types

class JSONUserType implements EnhancedUserType, Serializable {

    private static final int[] SQL_TYPES = [Types.VARCHAR]

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES
    }

    @Override
    public Class returnedClass() {
        return JSONObject.class
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true
        }
        if (x == null || y == null) {
            return false
        }
        JSONObject zx = (JSONObject) x
        JSONObject zy = (JSONObject) y
        return zx.equals(zy)
    }

    @Override
    public int hashCode(Object object) throws HibernateException {
        return object.hashCode()
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        Object jsonObject = StandardBasicTypes.STRING.nullSafeGet(resultSet, names, session, owner)
        if (jsonObject == null) {
            return null
        }
        return new JSONObject((String) jsonObject)
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index, SessionImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            StandardBasicTypes.STRING.nullSafeSet(preparedStatement, null, index, session)
        } else {
            JSONObject jsonObject = (JSONObject) value
            StandardBasicTypes.STRING.nullSafeSet(preparedStatement, jsonObject.toString(), index, session)
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value
    }

    @Override
    public boolean isMutable() {
        return false
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value
    }

    @Override
    public Object assemble(Serializable cached, Object value) throws HibernateException {
        return cached
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original
    }

    @Override
    public String objectToSQLString(Object object) {
        throw new UnsupportedOperationException()
    }

    @Override
    public String toXMLString(Object object) {
        return object.toString()
    }

    @Override
    public Object fromXMLString(String string) {
        return new JSONObject(string)
    }
}
