/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.display.context;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.io.Serializable;

/**
 * @author Drew Brokke
 */
public class ConfigurationScopeDisplayContext {

	public ConfigurationScopeDisplayContext(
		ExtendedObjectClassDefinition.Scope scope, Serializable scopePK) {

		_scope = scope;
		_scopePK = scopePK;
	}

	public ExtendedObjectClassDefinition.Scope getScope() {
		return _scope;
	}

	public Serializable getScopePK() {
		return _scopePK;
	}

	private final ExtendedObjectClassDefinition.Scope _scope;
	private final Serializable _scopePK;

}