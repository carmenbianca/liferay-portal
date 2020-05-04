/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.example.sample.internal;

import com.example.sample.GreetingBuilder;

/**
 * @author Andrea Di Giorgi
 */
public class GreetingBuilderImpl implements GreetingBuilder {

	public GreetingBuilderImpl(String name) {
		_name = name;
	}

	@Override
	public String getHello() {
		return "Hello " + getName();
	}

	@Override
	public String getName() {
		return _name;
	}

	private final String _name;

}