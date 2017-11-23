package com.holman.order.bo;

import com.holman.order.bo.exception.BOException;
import com.holman.order.dto.Order;

public interface OrderBO{
	
	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;
}
