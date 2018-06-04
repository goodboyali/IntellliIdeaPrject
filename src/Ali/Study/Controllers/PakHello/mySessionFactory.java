package Ali.Study.Controllers.PakHello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class mySessionFactory {


       private static SessionFactory sessionFactory ;


       private static SessionFactory getSessionFactory()
       {
           if(sessionFactory==null)
           {
               StandardServiceRegistry serviceRegistry=null;
               try {

                   StandardServiceRegistryBuilder _Builder=new StandardServiceRegistryBuilder().configure();

                   //可以动态更新这些设定
                   //_Builder=_Builder.applySetting("hibernate.connection.username", "root");
                    serviceRegistry=_Builder.build();
                   sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

               }
               catch (Exception ex)
               {
                   StandardServiceRegistryBuilder.destroy(serviceRegistry);
                   throw ex;
               }
           }

           return sessionFactory;
       }

       public static Session GetCurSession()
       {
           SessionFactory _sessionFact=getSessionFactory();
           return _sessionFact.getCurrentSession();
       }
}
