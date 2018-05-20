package com.coffee.back.service.impl;

import com.coffee.back.ConfigureReportDI;
import com.coffee.back.controller.ReportCtrl;
import com.coffee.back.controller.impl.ReportCtrlImpl;
import com.coffee.back.controller.vo.SaleVO;
import com.google.inject.Guice;
import com.google.inject.Injector;
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
public class ReportCtrlImplTest {

    private ReportCtrl reportCtrl;

    @Before
    public void init() {
        Injector injector = Guice.createInjector(new ConfigureReportDI());
        this.reportCtrl = injector.getInstance(ReportCtrlImpl.class);
    }

    @Test
    public void doReport() {
        String startDate = "2018-01-10";
        String endDate = "2018-09-12";
        /*
        Para formato de date posible cambio a futuro
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp s = new java.sql.Timestamp(date.getTime());
        */
        List<SaleVO> saleVOs = reportCtrl.recuperarVentas(startDate, endDate);
        saleVOs.forEach((sale) -> {
            System.out.printf("Venta con Id %s recuperado\n",sale.getSaleId());
        });
        assertNotNull(saleVOs);
    }
}
