package xin.codetop.mapper;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import xin.codetop.pojo.Order;

public interface UserMapper {
	@Transactional
	public abstract List<Order> getUserOrders(int param);
}
