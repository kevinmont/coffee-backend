package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.controller.vo.SaleVO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase parseadora de utilidad
 *
 * @author mont
 */
public class SaleParser {

    /**
     * Parsea un {@code SaleVO} a un {@code SaleDTO}
     *
     * @param saleToParser
     * @return
     */
    public static SaleDTO parseToUserDTO(SaleVO saleToParser) {
        SaleDTO userDTO = new SaleDTO();
        
        userDTO.setSaleId(saleToParser.getSaleId());
        userDTO.setDateSale(Date.valueOf(saleToParser.getDateSale()));
        userDTO.setTotalSale(saleToParser.getTotalSale());
        userDTO.setCashierNickName(saleToParser.getCashierNickName());
        
        List<SaleDTO.SaleProduct> products = new ArrayList<>();
        saleToParser.getSaleProduct().forEach((product) -> {
            SaleDTO.SaleProduct saleProduct = userDTO.new SaleProduct();
            saleProduct.setNeto(product.getNeto());
            saleProduct.setProductName(product.getProductName());
            saleProduct.setProductId(product.getProductId());
            saleProduct.setQuantityProduct(product.getQuantityProduct());
            products.add(saleProduct);
        });
        userDTO.setSaleProduct(products);
        return userDTO;
    }

    public static List<SaleVO> parseToUserVO(List<SaleDTO> saleDTOs) {
        List<SaleVO> saleVOs = new ArrayList<>();
        saleDTOs.forEach((sale) -> {
            SaleVO saleVO = new SaleVO();
            saleVO.setDateSale(sale.getDateSale().toLocalDate().toString());
            saleVO.setSaleId(sale.getSaleId());
            saleVO.setTotalSale(sale.getTotalSale());
            saleVO.setCashierNickName(sale.getCashierNickName());
            List<SaleVO.SaleProduct> productsSold = new ArrayList<>();
            sale.getSaleProduct().forEach((product) -> {
                SaleVO.SaleProduct productVO = saleVO.new SaleProduct();
                productVO.setProductName(product.getProductName());
                productVO.setQuantityProduct(product.getQuantityProduct());
                productsSold.add(productVO);
            });
            saleVO.setSaleProduct(productsSold);
            saleVOs.add(saleVO);
        });
        return saleVOs;
    }
}
