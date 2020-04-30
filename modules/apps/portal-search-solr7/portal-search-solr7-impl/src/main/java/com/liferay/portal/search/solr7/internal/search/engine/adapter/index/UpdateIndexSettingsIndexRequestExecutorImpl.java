/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.UpdateIndexSettingsIndexRequest;
import com.liferay.portal.search.engine.adapter.index.UpdateIndexSettingsIndexResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(
	immediate = true, service = UpdateIndexSettingsIndexRequestExecutor.class
)
public class UpdateIndexSettingsIndexRequestExecutorImpl
	implements UpdateIndexSettingsIndexRequestExecutor {

	@Override
	public UpdateIndexSettingsIndexResponse execute(
		UpdateIndexSettingsIndexRequest updateIndexSettingsIndexRequest) {

		throw new UnsupportedOperationException();
	}

}