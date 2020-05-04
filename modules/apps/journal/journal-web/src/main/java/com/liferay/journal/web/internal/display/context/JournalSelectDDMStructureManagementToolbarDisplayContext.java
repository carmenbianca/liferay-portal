/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class JournalSelectDDMStructureManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public JournalSelectDDMStructureManagementToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			JournalSelectDDMStructureDisplayContext
				journalSelectDDMStructureDisplayContext)
		throws Exception {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			journalSelectDDMStructureDisplayContext.getDDMStructureSearch());

		_journalSelectDDMStructureDisplayContext =
			journalSelectDDMStructureDisplayContext;
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/select_ddm_structure.jsp");
		portletURL.setParameter(
			"classPK",
			String.valueOf(
				_journalSelectDDMStructureDisplayContext.getClassPK()));
		portletURL.setParameter(
			"eventName",
			_journalSelectDDMStructureDisplayContext.getEventName());

		return portletURL.toString();
	}

	@Override
	public Boolean isSelectable() {
		return false;
	}

	@Override
	protected String[] getNavigationKeys() {
		return new String[] {"all"};
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"modified-date", "id"};
	}

	private final JournalSelectDDMStructureDisplayContext
		_journalSelectDDMStructureDisplayContext;

}