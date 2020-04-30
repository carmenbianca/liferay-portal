/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.web.internal.portlet.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;

import javax.portlet.PortletRequest;

/**
 * @author Pedro Queiroz
 */
public class PollsQuestionDisplayTerms extends DisplayTerms {

	public PollsQuestionDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
	}

}