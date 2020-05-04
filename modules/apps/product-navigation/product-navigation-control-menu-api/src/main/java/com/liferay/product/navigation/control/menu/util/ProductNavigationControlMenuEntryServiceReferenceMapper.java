/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.menu.util;

import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuEntry;

import org.osgi.framework.ServiceReference;

/**
 * @author Julio Camarero
 */
public class ProductNavigationControlMenuEntryServiceReferenceMapper
	implements ServiceReferenceMapper
		<String, ProductNavigationControlMenuEntry> {

	@Override
	public void map(
		ServiceReference<ProductNavigationControlMenuEntry> serviceReference,
		Emitter<String> emitter) {

		String productNavigationControlMenuCategoryKey =
			(String)serviceReference.getProperty(
				"product.navigation.control.menu.category.key");

		if (Validator.isNull(productNavigationControlMenuCategoryKey)) {
			_log.error(
				"Unable to register product navigation control menu entry " +
					"because of missing service property " +
						"\"product.navigation.control.menu.category.key\"");
		}
		else {
			emitter.emit(productNavigationControlMenuCategoryKey);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ProductNavigationControlMenuEntryServiceReferenceMapper.class);

}