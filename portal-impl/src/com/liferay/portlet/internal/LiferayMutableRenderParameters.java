/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import javax.portlet.MutableRenderParameters;

/**
 * @author Neil Griffin
 */
public interface LiferayMutableRenderParameters
	extends LiferayMutablePortletParameters, MutableRenderParameters {

	/**
	 * Returns <code>true</code> if the value of the parameter associated with
	 * the specified name has changed.
	 *
	 * @param  name the parameter's name
	 * @return <code>true</code> if the value of the parameter associated with
	 *         the specified name has changed; <code>false</code> otherwise
	 */
	public boolean isMutated(String name);

}