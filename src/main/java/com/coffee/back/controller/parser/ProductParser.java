package com.coffee.back.controller.parser;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.controller.vo.ProductVO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase parseadora de utilidad
 *
 * @author mont
 */
public class ProductParser {

    /**
     * Parsea un {@code ProductDTO} a un {@code ProductVO}
     *
     * @param productDTO Objeto a ser parseado
     * @return {@code ProductVO} objeto parseado
     */
    public static List<ProductVO> parseToProductVO(List<ProductDTO> productDTO) {
        List<ProductVO> parseProductVO = new ArrayList<>();
        productDTO.forEach((t) -> {
            ProductVO product = new ProductVO();
            product.setId(t.getProductId());
            product.setProductName(t.getProductName());
            product.setCategoryName(t.getCategoryName());
            product.setImage(t.getImage());
            product.setPriceTag(t.getPriceTag());
            product.setQuantity(t.getQuantity());
            parseProductVO.add(product);
        });
        return parseProductVO;
    }

    /**
     * Parsea un {@code ProductVO} a un {@code ProductDTO}
     *
     * @param productVO Objeto a ser parseado
     * @return {@code ProductDTO} objeto parseado
     */
    public static ProductDTO parseToProductDTO(ProductVO productVO) {
        ProductDTO parseProductDTO = new ProductDTO();
        parseProductDTO.setProductId(productVO.getId());
        parseProductDTO.setProductName(productVO.getProductName());
        parseProductDTO.setPriceTag(productVO.getPriceTag());
        parseProductDTO.setQuantity(productVO.getQuantity());
        parseProductDTO.setImage(productVO.getImage());
        parseProductDTO.setCategoryName(productVO.getCategoryName());
        return parseProductDTO;
    }

    /**
     * Parsea un {@code List<ProductDTO>} a un {@code List<ProductVO>}
     *
     * @param products Objeto a ser parseado
     * @return {@code List<ProductVO>} objeto parseado
     */
    public static List<ProductVO> parseToProductDTO(List<ProductDTO> products) {
        List<ProductVO> parserProductVO = new ArrayList<>();
        products.forEach((t) -> {
            ProductVO temp = new ProductVO();
            temp.setProductName(t.getProductName());
            temp.setImage(t.getImage());
            temp.setPriceTag(t.getPriceTag());
            temp.setQuantity(t.getQuantity());
            temp.setCategoryName(t.getCategoryName());
            parserProductVO.add(temp);
        });

        return parserProductVO;
    }
}
