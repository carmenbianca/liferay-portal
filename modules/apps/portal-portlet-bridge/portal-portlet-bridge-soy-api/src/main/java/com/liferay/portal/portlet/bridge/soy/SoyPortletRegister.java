/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.portlet.bridge.soy;

import java.util.Collections;
import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public interface SoyPortletRegister {

	public default Set<String> getJavaScriptRequiredModules(String path) {
		return Collections.emptySet();
	}

}