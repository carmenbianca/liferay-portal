/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.expando.util.comparator;

import com.liferay.expando.kernel.model.CustomAttributesDisplay;
import com.liferay.portal.kernel.security.permission.comparator.ModelResourceComparator;

import java.io.Serializable;

import java.util.Comparator;
import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 */
public class CustomAttributesDisplayComparator
	implements Comparator<CustomAttributesDisplay>, Serializable {

	public CustomAttributesDisplayComparator(Locale locale) {
		_modelResourceComparator = new ModelResourceComparator(locale);
	}

	@Override
	public int compare(
		CustomAttributesDisplay customAttributesDisplay1,
		CustomAttributesDisplay customAttributesDisplay2) {

		return _modelResourceComparator.compare(
			customAttributesDisplay1.getClassName(),
			customAttributesDisplay2.getClassName());
	}

	private final ModelResourceComparator _modelResourceComparator;

}