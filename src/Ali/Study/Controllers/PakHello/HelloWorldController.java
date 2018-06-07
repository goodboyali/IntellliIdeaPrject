package Ali.Study.Controllers.PakHello;

import Ali.Study.Entities.PakEntity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.List;


@Controller
@RequestMapping(value="/HelloWorld")
public class HelloWorldController {

    @RequestMapping(value="/Test",method=RequestMethod.GET)
    public String Test(Model model){

        model.addAttribute("msg", "ALIAA first spring mvc");

        String _str="EditBugChange";

        return "HelloWorld.html";
    }


    @RequestMapping(value="/Test1",method=RequestMethod.GET)
    @ResponseBody
    public String Test1(Model model){
        model.addAttribute("msg", "ALIAA first spring mvc");

        Session _session=mySessionFactory.GetCurSession();

        Transaction _Transaction= _session.beginTransaction();
        List<Users> _users= _session.createQuery("from Users").getResultList();
        Users _usrUP=_users.get(0);


        _usrUP.setUSR_NAME("NewName");

        _session.saveOrUpdate(_usrUP);

        _Transaction.commit();
        _session.close();

        String _msg="";
        for (Users _usr :
                _users) {

            _msg+=_usr.getUSR_ID()+":"+_usr.getUSR_NAME();
        }


        return _msg;
    }


    @RequestMapping(value="/Test2",method=RequestMethod.GET)
    public String Test2(Model model){

        Jedis jedis = new Jedis ("localhost",6379);
        jedis.auth("1234567");
        jedis.connect();//连接


        jedis.set("aaa","1");
        jedis.setex("bbb", 5, "2");

        jedis.disconnect();


        model.addAttribute("msg", "ALI first spring mvc");
        return "index.jsp";

    }

}
