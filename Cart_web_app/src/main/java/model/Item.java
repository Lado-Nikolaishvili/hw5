package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Item {

	private String id;
	private String name;
	private String image;
	private BigDecimal price;

	public static Item copy(Item item) {
		return new Item(item.getId(),
				item.getName(),
				item.getImage(),
				item.getPrice());
	}

}