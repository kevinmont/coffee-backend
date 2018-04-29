package com.coffee.back.service.impl;

import com.coffee.back.ConfigureProductDI;
import com.coffee.back.controller.impl.ProductCtrlImpl;
import com.coffee.back.controller.vo.ProductVO;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

/**
 *
 * @author mont
 */
@RunWith(JUnit4ClassRunner.class)
public class ProductServiceImplTest {
    
    private ProductCtrlImpl productCtrlImpl;
    
    
    @Before
    public void confi(){
           Injector injector = Guice.createInjector(new ConfigureProductDI());
           productCtrlImpl = injector.getInstance(ProductCtrlImpl.class);
    }
    
    @Test    
    public void altaProductoTest(){
        ProductVO newProduct = new ProductVO();
        newProduct.setProductName("prueba");
        newProduct.setQuantity((short)4);
        newProduct.setPriceTag(32.3);
        newProduct.setImage("ninguno");
        newProduct.setCategoryName("COMIDA");
        this.productCtrlImpl.altaProducto(newProduct);
    }
    
    @Test
    public void retrieveProduct(){
        String productName = "PEÑAFIEL";
        List<ProductVO> products=this.productCtrlImpl.buscarProducto(productName);
        products.forEach((t)->{
            System.out.println("hOLA "+t.getProductName());
        });
        assertNotNull(products);
        
    }
}
