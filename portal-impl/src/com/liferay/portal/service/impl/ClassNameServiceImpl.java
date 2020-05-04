/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.service.base.ClassNameServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@JSONWebService
public class ClassNameServiceImpl extends ClassNameServiceBaseImpl {

	@Override
	public ClassName fetchByClassNameId(long classNameId) {
		return classNameLocalService.fetchByClassNameId(classNameId);
	}

	@Override
	public ClassName fetchClassName(String value) {
		return classNameLocalService.fetchClassName(value);
	}

}