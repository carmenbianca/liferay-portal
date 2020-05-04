/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.internal.test;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.core.Application;

/**
 * @author Carlos Sierra Andrés
 */
public class TestInterfaceAnnotatedApplication
	extends Application implements TestAnnotatedInterface {

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	public String getString() {
		return "everything.read";
	}

	public String getStringNoScope() {
		return "no-scope";
	}

}