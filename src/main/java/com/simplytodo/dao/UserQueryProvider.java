package com.simplytodo.dao;

import org.springframework.stereotype.Component;

@Component("userQueryProvider")
public class UserQueryProvider {

    public String getUserByNameAndPhone(String name, String phone) throws IllegalArgumentException{
        return "SELECT * FROM User p WHERE p.name = '" + name + "' AND p.phone = '" + phone +"'";
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT u FROM todo_user WHERE");
//        sql.append(" AND u.name = '").append(name).append("'");
//
//        if(phone==null) {
//            sql.append(" AND u.phone IS NULL");
//        }else {
//            sql.append(" AND u.phone = '").append(phone).append("'");
//        }
//        return sql.toString();
    }
}
