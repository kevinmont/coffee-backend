package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.commons.dto.SaleDTO.SaleProduct;
import com.coffee.back.controller.vo.SaleVO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad
 * @author mont
 */
public class SaleParser {
    /**
     * Parsea un {@code SaleVO} a un {@code SaleDTO}
     * @param saleToParser
     * @return 
     */
    public static SaleDTO parseToUserDTO(SaleVO saleToParser){
        SaleDTO userDTO = new SaleDTO();
        userDTO.setWorkerId(saleToParser.getWorkerId());
        userDTO.setSaleId(saleToParser.getSaleId());
        userDTO.setDateSale(saleToParser.getDateSale());
        userDTO.setAmount(saleToParser.getAmount());
        List<SaleDTO.SaleProduct> products = new ArrayList<>();
        saleToParser.getSaleProduct().forEach((t)-> {
            SaleDTO.SaleProduct saleProduct= userDTO.new SaleProduct();
            saleProduct.setNeto(t.getNeto());
            saleProduct.setProductId(t.getProductId());
            saleProduct.setQuantityProduct(t.getQuantityProduct());
            products.add(saleProduct);
        });
        userDTO.setSaleProduct(products);
        return userDTO;
    }
}
