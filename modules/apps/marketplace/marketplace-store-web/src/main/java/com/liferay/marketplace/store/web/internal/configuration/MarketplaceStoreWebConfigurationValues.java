/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.store.web.internal.configuration;

/**
 * @author Joan Kim
 * @author Ryan Park
 */
public class MarketplaceStoreWebConfigurationValues {

	public static final String MARKETPLACE_KEY =
		MarketplaceStoreWebConfigurationUtil.get("marketplace.key");

	public static final String MARKETPLACE_PORTLET_ID =
		MarketplaceStoreWebConfigurationUtil.get("marketplace.portlet.id");

	public static final String MARKETPLACE_SECRET =
		MarketplaceStoreWebConfigurationUtil.get("marketplace.secret");

	public static final String MARKETPLACE_URL =
		MarketplaceStoreWebConfigurationUtil.get("marketplace.url");

}