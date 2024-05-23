package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {
	int pg = 1;
	int sz = 15;
	int recordCount;

	public int getFirstRecordIndex() {
		return (pg - 1) * sz;
	}

	public String getQueryString() {
		return String.format("pg=%d&sz=%d", pg, sz);
	}
}
