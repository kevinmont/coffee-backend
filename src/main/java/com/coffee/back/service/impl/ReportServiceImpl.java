package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.ProductDTO;
import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.commons.exception.NotFoundException;
import com.coffee.back.dao.ProductDAO;
import com.coffee.back.dao.SaleDAO;
import com.coffee.back.dao.SaleProductDAO;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.service.ReportService;
import com.google.inject.Inject;
import java.sql.Date;
import java.util.List;

/**
 * Clase {@code ReportServiceImpl} encargada de ejecutar la logica de negocio.
 *
 * @author mont
 */
public class ReportServiceImpl implements ReportService {

    private SaleDAO saleDao;
    private SaleProductDAO saleProductDao;
    private UserDAO userDao;
    private ProductDAO productDao;

    @Override
    public List<SaleDTO> recoverSales(Date since, Date until) {
        // Se recuperan las ventas
        List<SaleDTO> saleDTOs = this.saleDao.getSales(since, until);
        if (!saleDTOs.isEmpty()) {
            // Se recorre cada venta y se le agregan los productos
            //pertenecientes a esa venta.
            saleDTOs.forEach((sale) -> {

                List<SaleDTO.SaleProduct> saleProducts = this.saleProductDao.getProductsSoldByThisSale(sale.getSaleId());
                saleProducts.forEach((saleProduct) -> {
                    ProductDTO product = this.productDao.findProductById(saleProduct.getProductId());
                    saleProduct.setProductName(product.getProductName());
                });

                try {
                    sale.setCashierNickName(this.userDao.getUserById(sale.getCashierId()).getUserName());
                } catch (NotFoundException ex) {
                    // si no se encuentra el cajero es porque ha sido eliminado
                    // por lo tanto es desconocido
                    sale.setCashierNickName("Uknown");
                }
                sale.setSaleProduct(saleProducts);
            });
        }
        return saleDTOs;
    }

    @Inject
    public void setSaleDAO(SaleDAO saleDao) {
        this.saleDao = saleDao;
    }

    @Inject
    public void setSaleProductDAO(SaleProductDAO saleProductDao) {
        this.saleProductDao = saleProductDao;
    }

    @Inject
    public void setUserDAO(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Inject
    public void setProductDAO(ProductDAO productDao) {
        this.productDao = productDao;
    }
}
