/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import org.hibernate.Session;

public class Start 
{
    static Session session;
    public static void main(String [] s)
    {
         session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Event event = new Event();
         event.setAccount("Pasha");
         event.setPassword("Hello");
         session.save(event);
         session.getTransaction().commit();
    }
}
