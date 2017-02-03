package org.duckland;

import java.util.List;
import java.util.ArrayList;

public class PostalService implements DeliveryDriver {
	private double[][] rateValues;
	
	public PostalService() {
		rateValues = new double[][] {
			// First Class
			{ 0.035, 0.040, 0.047, 0.195, 0.450, 0.500 },
			// Second Class
			{ 0.0035, 0.0040, 0.0047, 0.0195, 0.0450, 0.0500 },
			// Third Class
			{ 0.0020, 0.0022, 0.0024, 0.0150, 0.0160, 0.0170 }
		};
	}
	
	// Weight is always in ounces
	@Override
	public List<Rate> calculateRate(int weight, int distance) {
		List<Rate> rates = new ArrayList<Rate>();
		// First weight group
		if(weight > 9 * 16) {
			double classRate = rateValues[0][5];
			Rate firstClass = new Rate("Postal Service First Class", distance * classRate);
			rates.add(firstClass);
			
			classRate = rateValues[1][5];
			Rate secondClass = new Rate("Postal Service Second Class", distance * classRate);
			rates.add(secondClass);
			
			classRate = rateValues[2][5];
			Rate thirdClass = new Rate("Postal Service Third Class", distance * classRate);
			rates.add(thirdClass);
		}
		
		return rates;
	}
}



/*
|--------|-----------|-----------|-----------|
|        | 1st Class | 2nd Class | 3rd Class |
| Ounces | Per Mile  | Per Mile  | Per Mile  |
|--------|-----------|-----------|-----------|
| 0 - 2  |   0.035   |   0.0035  |   0.0020  |
| 3 - 8  |   0.040   |   0.0040  |   0.0022  |
| 9 - 15 |   0.047   |   0.0047  |   0.0024  |
| Pounds |           |           |           |
| 1 - 3  |   0.195   |   0.0195  |   0.0150  |
| 4 - 8  |   0.450   |   0.0450  |   0.0160  |
| 9+     |   0.500   |   0.0500  |   0.0170  |
|--------|-----------|-----------|-----------|
*/
