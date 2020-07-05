package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemInfo {

	private Item item;
	private long count;

	public void addCount(long count) {
		this.count += count;
	}

}
