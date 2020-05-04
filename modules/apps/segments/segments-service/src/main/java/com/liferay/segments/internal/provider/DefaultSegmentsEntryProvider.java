/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.internal.provider;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.segments.constants.SegmentsEntryConstants;
import com.liferay.segments.odata.retriever.ODataRetriever;
import com.liferay.segments.provider.SegmentsEntryProvider;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = {
		"segments.entry.provider.order:Integer=100",
		"segments.entry.provider.source=" + SegmentsEntryConstants.SOURCE_DEFAULT
	},
	service = SegmentsEntryProvider.class
)
public class DefaultSegmentsEntryProvider
	extends BaseSegmentsEntryProvider implements SegmentsEntryProvider {

	@Activate
	protected void activate(BundleContext bundleContext) {
		serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, ODataRetriever.class, "model.class.name");
	}

	@Deactivate
	protected void deactivate() {
		serviceTrackerMap.close();
	}

	@Override
	protected String getSource() {
		return SegmentsEntryConstants.SOURCE_DEFAULT;
	}

}