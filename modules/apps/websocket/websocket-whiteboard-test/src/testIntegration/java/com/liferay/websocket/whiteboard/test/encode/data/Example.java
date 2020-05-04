/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.websocket.whiteboard.test.encode.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Cristina González
 */
@XmlRootElement
public class Example {

	public Example() {
	}

	public Example(int number, String data) {
		_number = number;
		_data = data;
	}

	public String getData() {
		return _data;
	}

	public int getNumber() {
		return _number;
	}

	public void setData(String data) {
		_data = data;
	}

	public void setNumber(int number) {
		_number = number;
	}

	private String _data;
	private int _number;

}