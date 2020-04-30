/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample;

/**
 * @author Andrea Di Giorgi
 */
public class GreetingBuilder {

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

	private final String _name;

}