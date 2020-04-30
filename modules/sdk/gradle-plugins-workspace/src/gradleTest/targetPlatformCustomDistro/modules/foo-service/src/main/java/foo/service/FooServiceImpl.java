/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package foo.service;

import foo.api.FooService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Liferay
 */
@Component(service = FooService.class)
public class FooServiceImpl implements FooService {

	@Override
	public String bar() {
		return "foobar";
	}

}