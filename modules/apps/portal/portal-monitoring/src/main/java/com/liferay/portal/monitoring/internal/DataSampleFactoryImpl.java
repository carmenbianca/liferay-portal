/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.monitoring.internal;

import com.liferay.portal.kernel.monitoring.DataSample;
import com.liferay.portal.kernel.monitoring.DataSampleFactory;
import com.liferay.portal.kernel.monitoring.MethodSignature;
import com.liferay.portal.kernel.monitoring.PortletRequestType;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.monitoring.internal.statistics.portal.PortalRequestDataSample;
import com.liferay.portal.monitoring.internal.statistics.portlet.PortletRequestDataSample;
import com.liferay.portal.monitoring.internal.statistics.service.ServiceRequestDataSample;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Michael C. Han
 */
@Component(enabled = false, immediate = true, service = DataSampleFactory.class)
public class DataSampleFactoryImpl implements DataSampleFactory {

	@Override
	public DataSample createPortalRequestDataSample(
		long companyId, long groupId, String referer, String remoteAddr,
		String remoteUser, String requestURI, String requestURL,
		String userAgent) {

		return new PortalRequestDataSample(
			companyId, groupId, referer, remoteAddr, remoteUser, requestURI,
			requestURL, userAgent);
	}

	@Override
	public DataSample createPortletRequestDataSample(
		PortletRequestType requestType, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		return new PortletRequestDataSample(
			requestType, portletRequest, portletResponse, _portal);
	}

	@Override
	public DataSample createServiceRequestDataSample(
		MethodSignature methodSignature) {

		return new ServiceRequestDataSample(methodSignature);
	}

	@Reference(
		cardinality = ReferenceCardinality.OPTIONAL,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile Portal _portal;

}