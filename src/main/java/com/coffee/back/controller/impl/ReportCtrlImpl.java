package com.coffee.back.controller.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.controller.ReportCtrl;
import com.coffee.back.controller.parser.SaleParser;
import com.coffee.back.controller.vo.SaleVO;
import com.coffee.back.service.ReportService;
import com.google.inject.Inject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase {@code ReportCtrlImpl} es encargada de recibir las peticiones
 * lanzadas por el usuario desde la vista, se encarga de manejar y ejecutar los
 * servicos de un reporte
 *
 * @author mont
 */
public class ReportCtrlImpl implements ReportCtrl {

    ReportService reportService;

    @Override
    public List<SaleVO> recuperarVentas(String start, String finish) {
        Pattern datePattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
        Matcher startMatcher = datePattern.matcher(start);
        Matcher endMatcher = datePattern.matcher(finish);
        List<SaleVO> saleVOs = null;
        if (startMatcher.matches() && endMatcher.matches()) {
            Date startDate = Date.valueOf(start);
            Date endDate = Date.valueOf(finish);
            // Se recuperan las ventas.
            List<SaleDTO> saleDTOs = this.reportService.recoverSales(startDate, endDate);
            saleVOs = SaleParser.parseToUserVO(saleDTOs);
        } else {
            // Lista vacia
            saleVOs = new ArrayList<>();
        }
        return saleVOs;
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Inject
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }
}
