/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.configuration.persistence.listener;

import com.liferay.portal.configuration.persistence.listener.ConfigurationModelListener;
import com.liferay.portal.servlet.filters.cache.CacheUtil;

import java.util.Dictionary;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jonathan McCann
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.journal.configuration.JournalServiceConfiguration",
	service = ConfigurationModelListener.class
)
public class JournalServiceConfigurationListener
	implements ConfigurationModelListener {

	@Override
	public void onAfterSave(String pid, Dictionary<String, Object> properties) {
		CacheUtil.clearCache();
	}

}