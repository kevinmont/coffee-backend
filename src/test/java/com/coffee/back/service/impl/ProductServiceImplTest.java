package com.coffee.back.service.impl;

import com.coffee.back.controller.impl.ProductCtrlImpl;
import com.coffee.back.controller.vo.ProductVO;
import com.coffee.back.dao.impl.ProductDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

/**
 *
 * @author mont
 */
@RunWith(AllTests.class)
public class ProductServiceImplTest {
    
    private ProductServiceImpl productServiceImpl;
    private ProductDAOImpl productDAOImpl;
    private ProductCtrlImpl productCtrlImpl;
    @Before
    public void confi(){
        productServiceImpl = new  ProductServiceImpl();
        productDAOImpl = new ProductDAOImpl();
        productCtrlImpl = new ProductCtrlImpl();
        productCtrlImpl.setProductService(productServiceImpl);
        productServiceImpl.setProductDAO(productDAOImpl);
    }
    
    @Test    
    public void altaProductoTest(){
        ProductVO test = new ProductVO();
        test.setProductId(20);
        test.setProductName("prueba");
        test.setPriceTag(32.3);
        test.setIsFood(false);
        test.setQuantity((short)4);
        test.setImage("ninguno");
        test.setCategoryId(1);
        
        this.productCtrlImpl.altaProducto(test);
    }
}