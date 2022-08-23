package com.example;

import ch.vorburger.mariadb4j.DB;

public class IniciaDB {
    
    public static void main(String[] args) throws Exception {
        
        DB db = DB.newEmbeddedDB(3306);

        db.start();

        System.out.println("Creating DB");
        db.createDB("testing");

        System.out.println("Loading SQLs");
        db.source("com/example/sqls/init.sql");

        System.out.println("Ready...");

    }


}
