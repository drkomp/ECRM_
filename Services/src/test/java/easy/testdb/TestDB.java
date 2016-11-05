package easy.testdb;

import com.easycrm.hibernate.Factory;
import com.easycrm.hibernate.HibernateUtil;
import com.easycrm.contragents.*;
import com.easycrm.users.Employee;
import com.easycrm.users.Master;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Created by drkomp on 02.10.2016.
 */
public class TestDB {
    public static void main(String[] args) {
        testAddUser();
        //testAddOrgToClient();
        //        testAddClient();
//        HibernateUtil.getSessionFactory().close();
        System.out.println("After try");

    }
    public static void testGetClient(){
        Client clientTwo;

    }
    public static void testAddClient(){
        Client clAddressed = new Client().setName("Петро").setPatronymic("Якович").setSurname("Вус");

        Client client1 = new Client().setNamePrefix("Mr.").setName("Vasilij").setSurname("Lisicky").setPatronymic("Prokofievich");
        client1.setNameSuffix("XII").setNickName("VALIS").setPhoneticName("Vasilij-").setPhoneticSurname("Lisitskij");
        client1.setNotes("bussiness trip to Kiev at 2016").setAddressed(clAddressed);

        Phone p1 = new Phone("Work", "0998765432", client1);
        Phone p2 = new Phone("Home","(057)755-21-34", client1);
        Address a1 = new Address().setType("Home").setIndex("61222").setAddress("Pushkinskaya str. 34").setCity("Kharkov");
        a1.setNeighborhood("Academy Yaroslava Mudrogo").setRoute("5 minute walk from metro Pushkinskaja ").setContragent(client1);
        Address a2 = new Address().setType("Work").setCity("Krarkov").setAddress("Geroev Truda str. 21,33 ").setContragent(client1);
        Chat ch1 = new Chat("skype","lis_3245", client1);
        Chat ch2 = new Chat("viber","380687654321",client1);
        ContragentEvent ev1 = new ContragentEvent("birthday","21.10.1981",client1);
        ContragentEvent ev2 = new ContragentEvent("wedding anniversary","11.09.2005",client1);
        Email em1 = new Email("privat","lisicky_vas@gmail.com",client1);
        Email em2 = new Email("work","lisicky_vasily@tavriav.com.ua",client1);
        WebSite web1 = new WebSite("privat blog","bestfood.blogspot.com",client1);
        WebSite web2 = new WebSite("company site","tavriav.com.ua",client1);

        try (SessionFactory s = HibernateUtil.getSessionFactory()){
//            Factory.getInstance().getPhoneDao().addIt(p1);
//            Factory.getInstance().getAddressDao().addIt(a1);
//            Phone ppp= Factory.getInstance().getPhoneDao().getItById(Phone.class,1);
//            System.out.println(ppp.getId()+" phone=  "+ ppp.getPhone()+ " type="+ppp.getType());
            Factory.getInstance().getClientDao().persistIt(client1);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void testAddOrgToClient(){
//        Organization o1 = new Organization().setName("Таврия-В").setNotes("normal store").setPhoneticName("tavria-v");
//        o1.setErdpu("2129445321");
        try (SessionFactory s = HibernateUtil.getSessionFactory()){
            try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
                Transaction tx =  HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

                Organization o1 = Factory.getInstance().getOrganizationDao().getItById( 6);
//            Factory.getInstance().getaOrganizationDao().addIt(o1);

                Client cl1 = Factory.getInstance().getClientDao().getItById( 2);
                System.out.println("before update org");
//                cl1.getOrganizations().add(o1);
                o1.getClients().add(cl1);
                cl1.setNotes("Updated new notes!");
                System.out.println("client ID=" + cl1.getId());
                Factory.getInstance().getClientDao().mergeIt(cl1);
                Factory.getInstance().getOrganizationDao().mergeIt(o1);
                tx.commit();
                Class.forName("User").newInstance();
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("In catch");
            System.out.println(e);
        }
    }
    public static void testAddUser(){
//        Organization o1 = new Organization().setName("Таврия-В").setNotes("normal store").setPhoneticName("tavria-v");
//        o1.setErdpu("2129445321");
        try (SessionFactory s = HibernateUtil.getSessionFactory()){
            try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
                Transaction tx =  HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
                Employee em = new Employee().setName("Юрий").setSurname("Молоток").setPatronymic("Федорович")
                        .setPosition("техник");
                Master master = new Master().setBaned(false).setNickName("molotok")
                        .setPassword("MasterPassword").setEmployee(em);
                em.getUsers().add(master);
                Factory.getInstance().getMasterDao().persistIt(master);

                tx.commit();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("In catch");
            System.out.println(e);
        }
    }
}
