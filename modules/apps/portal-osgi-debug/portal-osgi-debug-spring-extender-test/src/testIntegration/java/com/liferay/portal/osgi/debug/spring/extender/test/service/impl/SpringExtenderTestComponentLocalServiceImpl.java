/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.debug.spring.extender.test.service.impl;

import com.liferay.portal.osgi.debug.spring.extender.test.reference.SpringExtenderTestComponentReference;
import com.liferay.portal.spring.extender.service.ServiceReference;

/**
 * @author Matthew Tambara
 */
public class SpringExtenderTestComponentLocalServiceImpl {

	@ServiceReference(type = SpringExtenderTestComponentReference.class)
	protected SpringExtenderTestComponentReference
		springExtenderTestComponentReference;

}