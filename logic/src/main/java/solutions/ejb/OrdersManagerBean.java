package solutions.ejb;

import solutions.domain.Order;
import solutions.domain.Thing;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class OrdersManagerBean {
    @PersistenceContext(unitName = "shopPU")
    private EntityManager entityManager;

    public Order createOrder() {
        Order order = new Order();
        entityManager.persist(order);
        return order;
    }

    public Thing createThing(String name, int price) {
        Thing thing = new Thing();
        thing.setName(name);
        thing.setPrice(price);
        entityManager.persist(thing);

        return thing;
    }

}
