/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.deploy.hot;

import com.liferay.portal.kernel.url.URLContainer;

import java.util.List;

/**
 * @author Peter Fellwock
 * @author Raymond Augé
 */
public interface CustomJspBag {

	public String getCustomJspDir();

	public List<String> getCustomJsps();

	public URLContainer getURLContainer();

	public boolean isCustomJspGlobal();

}