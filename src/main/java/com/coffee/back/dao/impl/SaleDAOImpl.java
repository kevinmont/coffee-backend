package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.SaleDTO;
import com.coffee.back.commons.exception.TransactionException;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.SaleDAO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Clase {@code SaleDAOImpl} encargada de implementar {@code SaleDAO } 
 * la cual establece solicitudes con el servidor
 * de la base de datos de tipo CRUD
 * @see SaleDAO
 * @author mont
 */
public class SaleDAOImpl extends AbstractDAO implements SaleDAO {
    
    @Override
    public int create(List<SaleDTO> products) throws TransactionException {
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0; 
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into "
                    + "sale(worker_id, sale_id, date_sale, amount)"
                    + "values (?, ?, ? ,?)");
            Iterator<SaleDTO> saleDTO = (Iterator<SaleDTO>) products.iterator();
            while(saleDTO.hasNext()){
                preparedStatement.setInt(1, saleDTO.next().getWorkerId());
                preparedStatement.setInt(2, saleDTO.next().getSaleId());
                preparedStatement.setDate(3, (Date) saleDTO.next().getDateSale());
                preparedStatement.setDouble(4, saleDTO.next().getAmount());
                preparedStatement.executeUpdate();
            }
            
            connection.commit();
        } catch (SQLException ex) {
            
        }
        return 0;
    }
    
}
