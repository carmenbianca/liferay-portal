/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.taglib.internal.servlet.servlet.reading.time;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.reading.time.message.ReadingTimeMessageProvider;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = {})
public class ReadingTimeUtil {

	public static ReadingTimeMessageProvider getReadingTimeMessageProvider(
		String displayStyle) {

		ReadingTimeMessageProvider readingTimeMessageProvider =
			_readingTimeUtil._serviceTrackerMap.getService(displayStyle);

		if (readingTimeMessageProvider == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					String.format(
						"Reading time provider \"%s\" is not available",
						displayStyle));
			}
		}

		return readingTimeMessageProvider;
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_readingTimeUtil = this;

		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, ReadingTimeMessageProvider.class, "display.style");
	}

	@Deactivate
	protected void deactivate() {
		_readingTimeUtil = null;

		_serviceTrackerMap.close();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ReadingTimeUtil.class);

	private static ReadingTimeUtil _readingTimeUtil;

	private ServiceTrackerMap<String, ReadingTimeMessageProvider>
		_serviceTrackerMap;

}