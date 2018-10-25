/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine;

import Controller.Controller;
import Dao.VendingDaoFile;
import Dao.VendingDaoFileImpl;
import Dao.VendingLoggingDao;
import Dao.VendingLoggingDaoFileImpl;
import Service.VendingMachineServiceLayer;
import Service.VendingMachineServiceLayerImpl;
import UI.UserIO;
import UI.UserIOImpl;
import UI.VendingMachineView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 *
 * @author j1bdw02
 */
public class App {
    public static void main(String[] args)throws Exception {
//        VendingDaoFile myDao = new VendingDaoFileImpl();
//        VendingLoggingDao loggingDao = new VendingLoggingDaoFileImpl();
//        UserIO myIO = new UserIOImpl();
//        VendingMachineView myView = new VendingMachineView(myIO);
//        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, loggingDao);
//
//        Controller myController = new Controller(myView, myService);
//
//        myController.runProgram();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ctx.getBean("controller", Controller.class);
        controller.runProgram();
    }
}
