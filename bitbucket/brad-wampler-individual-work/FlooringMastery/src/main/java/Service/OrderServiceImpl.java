/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.AuditDao;
import DAO.DaoFileException;
import DAO.OrderDao;
import DAO.OrderDaoFileImpl;
import DAO.OrderDaoTraining;
import DTO.Order;
import DTO.Product;
import DTO.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author j1bdw02
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao;
    AuditDao auditDao;
        
    public OrderServiceImpl(OrderDao orderDao, AuditDao auditDao) {
        this.orderDao = orderDao;
        this.auditDao = auditDao;
    }
    
    @Override
    public List<Order> listOrdersService(LocalDate date) throws Exception {
        return orderDao.listOrders(date);
    }
    @Override
    public Order findOrderEdit(Integer orderNumber, LocalDate date) throws DaoFileException{
            return orderDao.findOrder(date, orderNumber);
    }
   /* @Override
    public Order compileOrderEdit (String name, String state, String product, BigDecimal area, Order newOrder){
        newOrder.setCustomerName(name);
        newOrder.setState(state);
        newOrder.setProduct(product);
        newOrder.setArea(area);
        return newOrder;
    }*/
    @Override
    public Order generateOrderNumber(Order newOrder){
        //DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");
        //String fileName = "Orders_" + LocalDate.now().format(dateFormat) + ".txt";
        List<Order> orders;
        int orderNumber = 0;
        try{
            orders = orderDao.listOrders(LocalDate.now());
            for (Order currentOrder: orders){
                
                orderNumber = currentOrder.getOrderNumber()+1;
                System.out.println(orderNumber);
            }
            newOrder.setOrderNumber(orderNumber);
        }catch(DaoFileException e){
            newOrder.setOrderNumber(1);
        }
        return newOrder;
    }
    @Override
    public Order calculateTotals(Order newOrder, Tax newTax, Product newProduct){
        newOrder.setTaxRate(newTax.getTaxRate());
        newOrder.setCostPerFoot(newProduct.getMaterialCostPerFoot());
        newOrder.setLaborPerFoot(newProduct.getLaborCostPerFoot());
        newOrder.setLaborCost(newOrder.getLaborPerFoot().multiply(newOrder.getArea()).setScale(2,RoundingMode.HALF_UP));
        newOrder.setMaterialCost(newOrder.getCostPerFoot().multiply(newOrder.getArea()).setScale(2,RoundingMode.HALF_UP));
        newOrder.setTax(newOrder.getMaterialCost().multiply(newOrder.getTaxRate()).divide(new BigDecimal("100")).setScale(2,RoundingMode.HALF_UP)
                .add(newOrder.getLaborCost().multiply(newOrder.getTaxRate().divide(new BigDecimal("100"))).setScale(2, RoundingMode.HALF_UP)));
        newOrder.setTotal(newOrder.getTax().add(newOrder.getMaterialCost().add(newOrder.getLaborCost())));
        return newOrder;
    }
    @Override
    public void submitOrder (LocalDate date, String confirm, Order newOrder, String action)throws DaoFileException{
        if (confirm.equalsIgnoreCase("y")){
            orderDao.addToList(newOrder, date);
            //auditDao.writeAuditEntry(removeOrder.getOrderNumber() + " removed from " + date);
        }else{}
    }  
    @Override
    public void removeOrderService (String confirm, Order removeOrder, LocalDate date) throws DaoFileException{
        if (confirm.equalsIgnoreCase("y")){
            orderDao.removeOrder(removeOrder, date);
            
        }else {}
    }
    @Override
    public void saveDataService()throws DaoFileException{
        orderDao.saveData();
        //auditDao.writeAuditEntry(newOrder.getOrderNumber() + " " + action + " from " + date);
    }
    @Override
    public String switchMode(int selection){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        if (selection == 2){
            OrderDao productionDao = ctx.getBean("myOrderDao", OrderDaoFileImpl.class);
            this.orderDao = productionDao;
            return "Production mode selected";
        }else{       
            OrderDao trainingDao = ctx.getBean("myTrainingOrderDao", OrderDaoTraining.class);
            this.orderDao = trainingDao;
            return "Training mode selected";
        }
        
    }
}
