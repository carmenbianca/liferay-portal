/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.portlet;

import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Neil Griffin
 */
public interface PortletDependency extends Serializable {

	public String getName();

	public String getScope();

	public Type getType();

	public String getVersion();

	public StringBundler toStringBundler();

	public enum Type {

		CSS, JAVASCRIPT, OTHER

	}

}