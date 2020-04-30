/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

import com.liferay.asset.kernel.NoSuchClassTypeException;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author Shuyang Zhou
 */
public class NullClassTypeReader implements ClassTypeReader {

	@Override
	public List<ClassType> getAvailableClassTypes(
		long[] groupIds, Locale locale) {

		return Collections.emptyList();
	}

	@Override
	public ClassType getClassType(long classTypeId, Locale locale)
		throws PortalException {

		throw new NoSuchClassTypeException();
	}

}