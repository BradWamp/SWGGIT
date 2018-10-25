/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary;
import Controller.DvdController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author bwamp
 */
public class App {
    public static void main(String[] args) {
       /* UserIO myIo = new UserIOImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdDao myDao = new DvdDaoFileImpl();
                
        DvdController runProgram = new DvdController(myDao, myView);
        runProgram.run();*/
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdController controller = ctx.getBean("controller", DvdController.class);
        controller.run();
    }
    
}