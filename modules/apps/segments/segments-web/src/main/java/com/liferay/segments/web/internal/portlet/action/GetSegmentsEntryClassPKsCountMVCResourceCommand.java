/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.web.internal.portlet.action;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.segments.constants.SegmentsPortletKeys;
import com.liferay.segments.criteria.Criteria;
import com.liferay.segments.criteria.contributor.SegmentsCriteriaContributorRegistry;
import com.liferay.segments.odata.retriever.ODataRetriever;
import com.liferay.segments.service.SegmentsEntryService;
import com.liferay.segments.web.internal.constants.SegmentsWebKeys;

import java.io.PrintWriter;

import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SegmentsPortletKeys.SEGMENTS,
		"mvc.command.name=getSegmentsEntryClassPKsCount"
	},
	service = MVCResourceCommand.class
)
public class GetSegmentsEntryClassPKsCountMVCResourceCommand
	implements MVCResourceCommand {

	@Override
	public boolean serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		try {
			PrintWriter printWriter = resourceResponse.getWriter();

			printWriter.write(getText(resourceRequest, resourceResponse));

			return false;
		}
		catch (Exception exception) {
			throw new PortletException(exception);
		}
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, ODataRetriever.class, "model.class.name");
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	protected int getSegmentsEntryClassPKsCount(
		long companyId, Criteria criteria, String type, Locale locale) {

		ODataRetriever oDataRetriever = _serviceTrackerMap.getService(type);

		if (oDataRetriever == null) {
			return 0;
		}

		try {
			return oDataRetriever.getResultsCount(
				companyId, criteria.getFilterString(Criteria.Type.MODEL),
				locale);
		}
		catch (PortalException portalException) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to obtain the segment user count", portalException);
			}

			return 0;
		}
	}

	protected String getText(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		HttpServletRequest httpServletRequest =
			_portal.getOriginalServletRequest(
				_portal.getHttpServletRequest(resourceRequest));

		long companyId = _portal.getCompanyId(httpServletRequest);

		String type = ParamUtil.getString(resourceRequest, "type");

		Criteria criteria = ActionUtil.getCriteria(
			resourceRequest,
			_segmentsCriteriaContributorRegistry.
				getSegmentsCriteriaContributors(type));

		saveCriteriaInSession(resourceRequest, criteria);

		int count = getSegmentsEntryClassPKsCount(
			companyId, criteria, type, _portal.getLocale(resourceRequest));

		return String.valueOf(count);
	}

	protected void saveCriteriaInSession(
		ResourceRequest resourceRequest, Criteria criteria) {

		PortletSession portletSession = resourceRequest.getPortletSession();

		portletSession.setAttribute(
			SegmentsWebKeys.PREVIEW_SEGMENTS_ENTRY_CRITERIA, criteria);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		GetSegmentsEntryClassPKsCountMVCResourceCommand.class);

	@Reference
	private Portal _portal;

	@Reference
	private SegmentsCriteriaContributorRegistry
		_segmentsCriteriaContributorRegistry;

	@Reference
	private SegmentsEntryService _segmentsEntryService;

	private ServiceTrackerMap<String, ODataRetriever> _serviceTrackerMap;

}