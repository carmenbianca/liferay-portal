/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.provider.zoom.servlet;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.powwow.model.PowwowMeeting;
import com.liferay.powwow.model.PowwowMeetingConstants;
import com.liferay.powwow.service.PowwowMeetingLocalServiceUtil;
import com.liferay.powwow.util.PortletPropsValues;

import java.io.IOException;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Marco Calderon
 */
public class ZoomAPICallbackServlet extends HttpServlet {

	@Override
	protected void doPost(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		if (!verifyRequest(httpServletRequest)) {
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);

			return;
		}

		try {
			String hostId = httpServletRequest.getParameter("host_id");
			String id = httpServletRequest.getParameter("id");
			String status = httpServletRequest.getParameter("status");

			if ((hostId == null) || (id == null) || (status == null)) {
				httpServletResponse.sendError(
					HttpServletResponse.SC_BAD_REQUEST);

				return;
			}

			for (long companyId : PortalUtil.getCompanyIds()) {
				long powwowMeetingId = getPowowwowMeetingId(
					companyId, hostId, id);

				if (powwowMeetingId == 0) {
					continue;
				}

				if (status.equals("ENDED")) {
					PowwowMeetingLocalServiceUtil.updateStatus(
						powwowMeetingId,
						PowwowMeetingConstants.STATUS_COMPLETED);
				}
				else if (status.equals("STARTED")) {
					PowwowMeetingLocalServiceUtil.updateStatus(
						powwowMeetingId,
						PowwowMeetingConstants.STATUS_IN_PROGRESS);
				}
			}

			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		}
		catch (Exception exception) {
			throw new IOException(exception);
		}
	}

	protected long getPowowwowMeetingId(
			long companyId, String zoomHostId, String zoomMeetingId)
		throws Exception {

		SearchContext searchContext = new SearchContext();

		BooleanQuery booleanQuery = new BooleanQueryImpl();

		booleanQuery.addExactTerm("zoomHostId", zoomHostId);
		booleanQuery.addExactTerm("zoomMeetingId", zoomMeetingId);

		BooleanClause booleanClause = BooleanClauseFactoryUtil.create(
			booleanQuery, BooleanClauseOccur.MUST.getName());

		searchContext.setBooleanClauses(new BooleanClause[] {booleanClause});

		searchContext.setCompanyId(companyId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(PowwowMeeting.class);

		Hits hits = indexer.search(searchContext);

		List<Document> documents = hits.toList();

		if (documents.isEmpty()) {
			return 0;
		}

		Document document = documents.get(0);

		return GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
	}

	protected boolean verifyRequest(HttpServletRequest httpServletRequest) {
		String authorization = httpServletRequest.getHeader("Authorization");

		if (authorization == null) {
			return false;
		}

		StringTokenizer st = new StringTokenizer(authorization);

		if (!st.hasMoreTokens()) {
			return false;
		}

		String basic = st.nextToken();

		if (!StringUtil.equalsIgnoreCase(
				basic, HttpServletRequest.BASIC_AUTH)) {

			return false;
		}

		String encodedCredentials = st.nextToken();

		String decodedCredentials = new String(
			Base64.decode(encodedCredentials));

		int pos = decodedCredentials.indexOf(CharPool.COLON);

		if (pos == -1) {
			return false;
		}

		String login = GetterUtil.getString(
			decodedCredentials.substring(0, pos));
		String password = decodedCredentials.substring(pos + 1);

		if (login.equals(PortletPropsValues.ZOOM_API_CALLBACK_LOGIN) &&
			password.equals(PortletPropsValues.ZOOM_API_CALLBACK_PASSWORD)) {

			return true;
		}

		return false;
	}

	private static final long serialVersionUID = 1L;

}