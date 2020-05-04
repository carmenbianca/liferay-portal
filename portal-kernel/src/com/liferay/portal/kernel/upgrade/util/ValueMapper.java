/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

import java.util.Iterator;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public interface ValueMapper {

	public void appendException(Object exception);

	public Object getNewValue(Object oldValue) throws Exception;

	public Iterator<Object> iterator() throws Exception;

	public void mapValue(Object oldValue, Object newValue) throws Exception;

	public int size() throws Exception;

}