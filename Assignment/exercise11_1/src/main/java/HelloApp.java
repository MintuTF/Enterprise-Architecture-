import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

    private  Greeting greeting;

    public  void greetingSet(){
        greeting.sayHello();
    }
    public static void main(String[] args) {
     ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("springconfig.xml");
       HelloApp greetingService =context.getBean("helloapp",HelloApp.class);
      //  greeting.sayHello();
//        greetingSet()



    }


    public void setGreeting(Greeting greeting) {

        this.greeting=greeting;

        greeting.sayHello();

    }
}
