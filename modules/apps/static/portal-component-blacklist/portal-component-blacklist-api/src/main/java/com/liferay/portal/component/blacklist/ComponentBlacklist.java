/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.component.blacklist;

import java.util.Set;

/**
 * @author Michael C. Han
 */
public interface ComponentBlacklist {

	public boolean contains(String componentName);

	public Set<String> getBlacklistComponentNames();

}