/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.ehcache.internal;

import net.sf.ehcache.Ehcache;

/**
 * @author Tina Tian
 */
public interface EhcacheWrapper {

	public Ehcache getEhcache();

}