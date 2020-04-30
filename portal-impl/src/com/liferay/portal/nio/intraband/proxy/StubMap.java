/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.nio.intraband.proxy;

import java.util.concurrent.ConcurrentMap;

/**
 * @author Shuyang Zhou
 */
public interface StubMap<T> extends ConcurrentMap<String, T> {

	public boolean removeStubHolder(String portletId, T stub);

}