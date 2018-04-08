package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.controller.vo.ProductVO;

/**
 *
 * @author mont
 */
public class ProductParser {
    
    public static ProductVO parseToProductVO(ProductDTO productDTO){
        ProductVO parseProductVO = new ProductVO();
        parseProductVO.setProductId(productDTO.getProductId());
        parseProductVO.setProductName(productDTO.getProductName());
        parseProductVO.setPriceTag(productDTO.getPriceTag());
        parseProductVO.setQuantity(productDTO.getQuantity());
        parseProductVO.setIsFood(productDTO.getIsFood());
        parseProductVO.setImage(productDTO.getImage());
        parseProductVO.setCategoryId(productDTO.getCategoryId());
        return parseProductVO;
    }
    
    public static ProductDTO parseToProductDTO(ProductVO productVO){
        ProductDTO parseProductDTO = new ProductDTO();
        parseProductDTO.setProductId(productVO.getProductId());
        parseProductDTO.setProductName(productVO.getProductName());
        parseProductDTO.setPriceTag(productVO.getPriceTag());
        parseProductDTO.setQuantity(productVO.getQuantity());
        parseProductDTO.setIsFood(productVO.getIsFood());
        parseProductDTO.setImage(productVO.getProductName());
        parseProductDTO.setCategoryId(productVO.getCategoryId());
        return parseProductDTO;
    }
}
