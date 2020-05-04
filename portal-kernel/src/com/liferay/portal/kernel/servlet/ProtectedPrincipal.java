/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import com.liferay.petra.string.StringPool;

import java.io.Serializable;

import java.security.Principal;

/**
 * @author Brian Wing Shun Chan
 */
public class ProtectedPrincipal implements Principal, Serializable {

	public ProtectedPrincipal() {
		this(StringPool.BLANK);
	}

	public ProtectedPrincipal(String name) {
		_name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProtectedPrincipal)) {
			return false;
		}

		ProtectedPrincipal protectedPrincipal = (ProtectedPrincipal)obj;

		String name = protectedPrincipal.getName();

		if (name.equals(_name)) {
			return true;
		}

		return false;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public int hashCode() {
		return _name.hashCode();
	}

	@Override
	public String toString() {
		return _name;
	}

	private final String _name;

}