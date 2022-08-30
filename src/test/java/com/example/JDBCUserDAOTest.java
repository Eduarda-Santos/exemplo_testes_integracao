package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.User;
import com.example.model.daos.IUserDAO;
import com.example.model.daos.JDBCUserDAO;



/**
 * Unit test for simple App.
 */
public class JDBCUserDAOTest{
    private Connection con;
    
    @BeforeEach
    public void antes() throws Exception{
        con = DriverManager.getConnection("jdbc:mysql://localhost/testing","root","");
        con.setAutoCommit(false);
    }

    @Test
    public void testInsereUsuario() throws Exception{

        User user = new User(-1, "Zé", "zé@teste.com");

        IUserDAO dao = new JDBCUserDAO(con);

        User atualizado = dao.add(user);

        assertNotEquals(-1, atualizado.getId());

    }

    @Test
    public void testBuscaUserPorEmail() throws Exception{

        User user = new User(-1, "Zé", "ze@teste.com");

        IUserDAO dao = new JDBCUserDAO(con);

        dao.add(user);

        User busca = dao.getByEmail("ze@teste.com");
        
        assertNotNull(busca);
        assertEquals("Zé", busca.getNome());

    }

    @AfterEach
    public void depois() throws Exception{
        con.rollback();
        con.close();
    }

}
