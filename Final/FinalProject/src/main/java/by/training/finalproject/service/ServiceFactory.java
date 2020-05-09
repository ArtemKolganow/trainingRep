package by.training.finalproject.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<String, Service> SERVICES = new HashMap<>();

    static {
        SERVICES.put("User", new UserServiceimpl());
        SERVICES.put("Product", new ProductServiceimpl());
        SERVICES.put("UserInfo", new UserInfoServiceimpl());
        SERVICES.put("Order", new OrderServiceimpl());
        SERVICES.put("CraftOrder", new CraftOrderServiceimpl());
        SERVICES.put("RegisteredProduct", new RegisteredProductServiceimpl());
    }

    public Service getService(String key) throws ServiceException {
        Service service = SERVICES.get(key);
        if(service!=null){
            return service;
        }else {
            throw new ServiceException("There is no service with this key.");
        }
    }
}
