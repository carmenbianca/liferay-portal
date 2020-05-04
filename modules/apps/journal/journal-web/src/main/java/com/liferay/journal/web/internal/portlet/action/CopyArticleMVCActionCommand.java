/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.portlet.action;

import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.exception.ArticleIdException;
import com.liferay.journal.exception.DuplicateArticleIdException;
import com.liferay.journal.exception.NoSuchArticleException;
import com.liferay.journal.service.JournalArticleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Eduardo García
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + JournalPortletKeys.JOURNAL,
		"mvc.command.name=copyArticle"
	},
	service = MVCActionCommand.class
)
public class CopyArticleMVCActionCommand extends BaseMVCActionCommand {

	protected void copyArticle(ActionRequest actionRequest) throws Exception {
		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		String oldArticleId = ParamUtil.getString(
			actionRequest, "oldArticleId");
		String newArticleId = ParamUtil.getString(
			actionRequest, "newArticleId");
		boolean autoArticleId = ParamUtil.getBoolean(
			actionRequest, "autoArticleId");
		double version = ParamUtil.getDouble(actionRequest, "version");

		_journalArticleService.copyArticle(
			groupId, oldArticleId, newArticleId, autoArticleId, version);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			copyArticle(actionRequest);
		}
		catch (Exception exception) {
			if (exception instanceof NoSuchArticleException ||
				exception instanceof PrincipalException) {

				SessionErrors.add(actionRequest, exception.getClass());

				PortletSession portletSession =
					actionRequest.getPortletSession();

				PortletContext portletContext =
					portletSession.getPortletContext();

				PortletRequestDispatcher portletRequestDispatcher =
					portletContext.getRequestDispatcher("/error.jsp");

				portletRequestDispatcher.include(actionRequest, actionResponse);
			}
			else if (exception instanceof ArticleIdException ||
					 exception instanceof DuplicateArticleIdException) {

				SessionErrors.add(actionRequest, exception.getClass());
			}
			else {
				throw exception;
			}
		}
	}

	@Reference(unbind = "-")
	protected void setJournalArticleService(
		JournalArticleService journalArticleService) {

		_journalArticleService = journalArticleService;
	}

	private JournalArticleService _journalArticleService;

}