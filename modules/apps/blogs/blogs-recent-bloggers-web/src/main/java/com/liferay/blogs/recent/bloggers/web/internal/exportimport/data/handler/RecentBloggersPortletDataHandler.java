/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.recent.bloggers.web.internal.exportimport.data.handler;

import com.liferay.blogs.recent.bloggers.constants.RecentBloggersPortletKeys;
import com.liferay.exportimport.kernel.lar.DataLevel;
import com.liferay.exportimport.kernel.lar.DefaultConfigurationPortletDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataHandler;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(
	property = "javax.portlet.name=" + RecentBloggersPortletKeys.RECENT_BLOGGERS,
	service = PortletDataHandler.class
)
public class RecentBloggersPortletDataHandler
	extends DefaultConfigurationPortletDataHandler {

	public static final String SCHEMA_VERSION = "1.0.0";

	@Override
	public String getSchemaVersion() {
		return SCHEMA_VERSION;
	}

	@Activate
	protected void activate() {
		setDataLevel(DataLevel.PORTLET_INSTANCE);
		setPublishToLiveByDefault(true);
	}

}