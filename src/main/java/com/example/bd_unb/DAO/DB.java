package com.example.bd_unb.DAO;//package com.example.bd_unb.DAO;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.util.Collection;
//import java.util.Properties;
//
//import org.hibernate.cfg.Configuration;
//
//
//
//public class DB {
//
//    private String scope;
//
//    private Collection<Class<? extends Object>> entities;
//
//    public DB(String scope, Collection<Class<? extends Object>> entities)
//    {
//        this.scope = scope;
//        this.entities = entities;
//    }
//
//    public void createEntityManager() {
//        Properties properties = new Properties();
//        properties.put("javax.persistence.provider", "org.hibernate.ejb.HibernatePersistence");
//        properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
//        properties.put("hibernate.connection.username", "sa");
//        properties.put("hibernate.connection.password" ,"");
//        properties.put("hibernate.connection.driver_class","org.h2.Driver");
//        properties.put("hibernate.connection.url", String.format("jdbc:h2:mem:%s;MODE=DB2", scope) );
//        properties.put("hibernate.dialect" ,"org.hibernate.dialect.H2Dialect");
//        properties.put("hibernate.hbm2ddl.auto","create-drop");
//
//        Configuration cfg = new Configuration();
//        cfg.addProperties(properties);
//        for(Class<?> clazz : entities)
//        {
//            cfg.addAnnotatedClass(clazz);
//        }
//
//        EntityManagerFactory factory;
//
//    }
//}
