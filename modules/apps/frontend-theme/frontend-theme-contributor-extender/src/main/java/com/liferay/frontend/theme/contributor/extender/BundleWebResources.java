/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.theme.contributor.extender;

import java.util.Collection;

/**
 * @author Carlos Sierra Andrés
 */
public interface BundleWebResources {

	public Collection<String> getCssResourcePaths();

	public Collection<String> getJsResourcePaths();

	public String getServletContextPath();

}