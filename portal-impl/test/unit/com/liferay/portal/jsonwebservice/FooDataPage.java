/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.jsonwebservice;

import com.liferay.portal.kernel.json.JSON;

import java.util.List;

/**
 * @author Igor Spasic
 */
public class FooDataPage {

	public FooDataPage(FooData data, List<FooData> list, int page) {
		_data = data;
		_list = list;
		_page = page;
	}

	public FooData getData() {
		return _data;
	}

	public List<FooData> getList() {
		return _list;
	}

	public int getPage() {
		return _page;
	}

	public void setData(FooData data) {
		_data = data;
	}

	public void setList(List<FooData> list) {
		_list = list;
	}

	public void setPage(int page) {
		_page = page;
	}

	private FooData _data;

	@JSON
	private List<FooData> _list;

	private int _page;

}