package com.holman.order.bo;

import static org.junit.Assert.*;

import org.junit.Before;

import com.holman.order.bo.OrderBOImpl;
import com.holman.order.bo.exception.BOException;
import com.holman.order.dao.OrderDAO;
import com.holman.order.dto.Order;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class OrderBOImplTest {

	@Mock
	private OrderDAO dao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setDao(dao);
		
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result= bo.placeOrder(order);
		
		assertTrue(result);
		
		verify(dao).create(order);
		
	}

}
