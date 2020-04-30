/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sample;

/**
 * @author Brian Wing Shun Chan
 */
public class GreetingBuilder {

	private String _name;

	public GreetingBuilder(String name) {
		_name = name;
	}

	public String getGoodbye() {
		return "Goodbye " + getName();
	}

	public String getHello() {
		return "Hello " + getName();
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

}