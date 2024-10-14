/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author hp
 */
public class EmployeTacheService implements IDao <EmployeTache> {

    @Override
    public boolean create(EmployeTache o) {
  Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;     }

    @Override
    public EmployeTache getById(int id) {
Session session = null;
        EmployeTache e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (EmployeTache) session.get(EmployeTache.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;        
    }

    @Override
    public List<EmployeTache> getAll() {
         Session session = null;
        List<EmployeTache>  employeTaches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
          employeTaches = session.createQuery("from EmployeTache").list();
            session.getTransaction().commit();
            return employeTaches;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return employeTaches ;
        
    }
    
}
