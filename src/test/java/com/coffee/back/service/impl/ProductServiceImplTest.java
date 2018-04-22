package com.coffee.back.service.impl;

import com.coffee.back.controller.impl.ProductCtrlImpl;
import com.coffee.back.controller.vo.ProductVO;
import com.coffee.back.dao.impl.CategoryDAOImpl;
import com.coffee.back.dao.impl.ProductDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

/**
 *
 * @author mont
 */
@RunWith(JUnit4ClassRunner.class)
public class ProductServiceImplTest {
    
    private ProductServiceImpl productServiceImpl;
    private ProductDAOImpl productDAOImpl;
    private ProductCtrlImpl productCtrlImpl;
    private CategoryServiceImpl categoryServiceImpl;
    private CategoryDAOImpl categoryDAOImpl;
    
    @Before
    public void confi(){
        this.productCtrlImpl = new ProductCtrlImpl();
        
        this.productServiceImpl = new  ProductServiceImpl();
        this.categoryServiceImpl = new  CategoryServiceImpl();
        
        this.productDAOImpl = new ProductDAOImpl();
        this.categoryDAOImpl = new CategoryDAOImpl();
        
        this.productCtrlImpl.setProductService(productServiceImpl);
        this.productCtrlImpl.setCategoryService(categoryServiceImpl);
        
        this.productServiceImpl.setProductDAO(productDAOImpl);
        this.categoryServiceImpl.setCategoryDAO(categoryDAOImpl);
        
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
}
