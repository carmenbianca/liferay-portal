/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.exportimport.portlet.preferences.processor;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerKeys;
import com.liferay.exportimport.portlet.preferences.processor.Capability;

import java.util.Map;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cristina González
 */
@Component(
	service = {
		Capability.class, DLCommentsAndRatingsExporterImporterCapability.class
	}
)
public class DLCommentsAndRatingsExporterImporterCapability
	implements Capability {

	@Override
	public PortletPreferences process(
		PortletDataContext portletDataContext,
		PortletPreferences portletPreferences) {

		Map<String, String[]> parameterMap =
			portletDataContext.getParameterMap();

		parameterMap.put(
			PortletDataHandlerKeys.COMMENTS,
			new String[] {Boolean.TRUE.toString()});
		parameterMap.put(
			PortletDataHandlerKeys.RATINGS,
			new String[] {Boolean.TRUE.toString()});

		return portletPreferences;
	}

}