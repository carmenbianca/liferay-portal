/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.sidecar;

import com.liferay.portal.search.elasticsearch7.internal.connection.SidecarElasticsearchConnectionManager;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = {})
public class SidecarComponentUtil {

	public static void disableSidecarElasticsearchConnectionManager() {
		_componentContext.disableComponent(
			SidecarElasticsearchConnectionManager.class.getName());
	}

	public static void enableSidecarElasticsearchConnectionManager() {
		_componentContext.enableComponent(
			SidecarElasticsearchConnectionManager.class.getName());
	}

	@Activate
	protected void activate(ComponentContext componentContext) {
		_componentContext = componentContext;
	}

	private static ComponentContext _componentContext;

}