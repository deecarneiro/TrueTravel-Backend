package model.beans;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.entities.Order;
import model.entities.OrderMessage;
import model.service.OrderService;
/**
 *
 * @author MASC
 */
@Stateless
public class OrderBean{
    

    @EJB
    private OrderService serviceOrder;
    private Order Order = new Order();
    List<Order> lista = new ArrayList<Order>();
    
    public void iniciarCampos() {
      serviceOrder.criar();
    }

    public Order salvar(Order entidade) {
//    entidade.setId(Long.MIN_VALUE);
        serviceOrder.persistir(entidade);
        return entidade;
    }
    
    public Order atualizar(Order order, int id) {
    	Order orderById = serviceOrder.consultar(id);
    	return serviceOrder.atualizar(order);
    }
    
    public void remover(int id) {
    	Order orderById = serviceOrder.consultar(id);
    	serviceOrder.remover(orderById);
    }

    public List<Order> getLista() {
        lista = serviceOrder.consultarEntidades();
        return lista;
    }
    
    
    public List<Order> getByProject(long id) {
    	List<Order> orders = serviceOrder.consultarPorProjeto(id);
    	return orders;
    }
    
    public List<Order> getByUser(long id) {
    	List<Order> orders = serviceOrder.consultarPorUser(id);
    	return orders;
    }
    
    public List<Order> getByStatus(int id) {
    	List<Order> orders = serviceOrder.consultarPorStatus(id);
    	return orders;
    }
    
    
    public Order getById(long id) {
    	Order = serviceOrder.consultar(id);
    	return Order;
    }

    public void setLista(List<Order> lista) {
        this.lista = lista;
    }

    public Order getOrder() {
        return Order;
    }

    public void setOrder(Order Order) {
        this.Order = Order;
    }
    

}
