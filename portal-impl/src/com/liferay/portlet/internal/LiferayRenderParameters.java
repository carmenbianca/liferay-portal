/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.util.Set;

import javax.portlet.RenderParameters;

/**
 * @author Neil Griffin
 */
public interface LiferayRenderParameters extends RenderParameters {

	/**
	 * Returns the public render parameter names.
	 *
	 * @return the public render parameter names
	 */
	public Set<String> getPublicRenderParameterNames();

}