package org.duckland;

import java.util.List;

public interface DeliveryDriver {
	List<Rate> calculateRate(int weight, int distance);
}