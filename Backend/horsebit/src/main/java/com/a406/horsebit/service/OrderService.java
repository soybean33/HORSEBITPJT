package com.a406.horsebit.service;

import java.util.List;

import com.a406.horsebit.dto.OrderDTO;

public interface OrderService {
	/**
	 * 미체결 내역 조회
	 * @param userNo
	 * @param tokenNo
	 * @return
	 */
	List<OrderDTO> getOrders(Long userNo, Long tokenNo);
}