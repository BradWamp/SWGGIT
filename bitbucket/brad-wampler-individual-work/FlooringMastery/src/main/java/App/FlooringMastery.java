/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author j1bdw02
 */
public class FlooringMastery {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserIO firstIO = new UserIOImpl();
        //FlooringView firstView = new FlooringView(firstIO);
        //Controller modeSelect = new Controller(firstView);
        //OrderDao myOrderDao;
        //UserIO myIO = new UserIOImpl();
        //myOrderDao = new OrderDaoFileImpl();
        Controller productionController = ctx.getBean("productController", Controller.class);
        productionController.run();
        //myOrderDao = new OrderDaoTraining();
         //TaxDao myTaxDao = new TaxDaoFileImpl();
        //ProductDao myProductDao = new ProductDaoFileImpl();
        //OrderService myOrderService = new OrderServiceImpl(myOrderDao);
        //TaxService myTaxService = new TaxServiceImpl(myTaxDao);
        //ProductService myProductService = new ProductServiceImpl(myProductDao);
        //FlooringView myView = new FlooringView(myIO);
        //Controller myController = new Controller(myView, myOrderService, myTaxService, myProductService);
        
        //myController.run();
    }
    
   

/*import com.sg.flooringmastery.controller.FlooringController;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) throws FlooringPersistenceException {

        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller; 
        
        if(args[0].equalsIgnoreCase("training")){
            controller = ctx.getBean("trainingController", FlooringController.class);
        } else { 
            controller = ctx.getBean("prodController", FlooringController.class);
        }
        controller.run();
    }
}*/
    
}
