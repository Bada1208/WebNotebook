package com.sysoiev.dao;

import com.sysoiev.model.Contact;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoMySqlClass {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Contact contact) {
        String sql = "insert into notebook(surname,name,phone_number,age) values('" + contact.getSurname() + "','" + contact.getName() + "','" + contact.getPhoneNumber() + "'," + contact.getAge() + ")";
        return template.update(sql);
    }

    public int update(Contact contact) {
        String sql = "update notebook set name='" + contact.getName() + "', surname='" + contact.getName() + "',phone_number='" + contact.getPhoneNumber() + "',age='" + contact.getAge() + "' where id='" + contact.getId() + ")'";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from notebook where id=" + id + "";
        return template.update(sql);
    }

    public Contact getContactById(int id) {
        String sql = "select * from notebook where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Contact>(Contact.class));
    }

    public List<Contact> getContacts() {
        return template.query("select * from notebook", new RowMapper<Contact>() {
            public Contact mapRow(ResultSet rs, int row) throws SQLException {
                Contact contact = new Contact();
                contact.setId(rs.getInt(1));
                contact.setSurname(rs.getString(2));
                contact.setName(rs.getString(3));
                contact.setPhoneNumber(rs.getString(4));
                contact.setAge(rs.getInt(5));
                return contact;
            }
        });
    }
}

