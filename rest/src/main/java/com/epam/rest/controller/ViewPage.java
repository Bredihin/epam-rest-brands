package com.epam.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

public class ViewPage<T> {

	private List<T> rows;

	private int page;
	private int records;
	private long total;

	public ViewPage() {
	}

	public ViewPage(int total, int page, int records, List<T> rows) {
		this.rows = rows;
		this.page = page;
		this.records = records;
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getJsonString() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("total", total);
		map.put("records", records);
		map.put("rows", rows);
		return JSONValue.toJSONString(map);
	}
}
