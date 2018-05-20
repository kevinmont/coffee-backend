package com.coffee.back.service.impl;

import com.coffee.back.ConfigureSaleDI;
import com.coffee.back.controller.SaleCtrl;
import com.coffee.back.controller.impl.SaleCtrlImpl;
import com.coffee.back.controller.vo.SaleVO;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
/**
 *
 * @author mont
 */
@RunWith(JUnit4ClassRunner.class)
public class SaleCtrlImplTest {
    
    private SaleCtrl saleCtrl;
    
    @Before
    public void init(){
        Injector injector= Guice.createInjector(new ConfigureSaleDI());
        this.saleCtrl= injector.getInstance(SaleCtrlImpl.class);
    }
    
    @Test 
    public void doSale(){
        SaleVO saleVO = new SaleVO();
        saleVO.setCashierNickName("ERI@EMP");
        saleVO.setSaleId(44);
        saleVO.setTotalSale(2300d);
        saleVO.setDateSale("2018-12-12");
        
        List<SaleVO.SaleProduct> products = new ArrayList<>();
        
        SaleVO.SaleProduct product1 = saleVO.new SaleProduct();
        product1.setProductId(8);
        product1.setNeto(13d);
        product1.setProductName("PEPSI");
        product1.setQuantityProduct(1);
        products.add(product1);
        
        saleVO.setSaleProduct(products);
        
        Integer saleID =this.saleCtrl.realizarVenta(saleVO);
        System.out.println("Sale with id "+ saleID +" has been registered");
        assertNotNull(saleID);
    }
}
