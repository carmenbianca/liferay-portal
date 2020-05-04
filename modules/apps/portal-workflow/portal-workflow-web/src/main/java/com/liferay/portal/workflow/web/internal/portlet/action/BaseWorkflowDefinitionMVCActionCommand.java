/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManager;
import com.liferay.portal.kernel.workflow.WorkflowException;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Jeyvison Nascimento
 */
public abstract class BaseWorkflowDefinitionMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		try {
			doProcessAction(actionRequest, actionResponse);

			addSuccessMessage(actionRequest, actionResponse);

			return SessionErrors.isEmpty(actionRequest);
		}
		catch (WorkflowException workflowException) {
			hideDefaultErrorMessage(actionRequest);

			SessionErrors.add(
				actionRequest, workflowException.getClass(), workflowException);

			return false;
		}
		catch (PortletException portletException) {
			throw portletException;
		}
		catch (Exception exception) {
			throw new PortletException(exception);
		}
	}

	protected void addDefaultTitle(
		ActionRequest actionRequest, Map<Locale, String> titleMap) {

		Locale defaultLocale = LocaleUtil.getDefault();

		if (Validator.isNull(titleMap.get(defaultLocale))) {
			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				defaultLocale, BaseWorkflowDefinitionMVCActionCommand.class);

			String defaultTitle = LanguageUtil.get(
				resourceBundle, "untitled-workflow");

			titleMap.put(defaultLocale, defaultTitle);
		}
	}

	@Override
	protected void addSuccessMessage(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		SessionMessages.add(
			actionRequest, "requestProcessed",
			getSuccessMessage(actionRequest));
	}

	@Override
	protected abstract void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception;

	protected ResourceBundle getResourceBundle(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return ResourceBundleUtil.getBundle(
			themeDisplay.getLocale(),
			BaseWorkflowDefinitionMVCActionCommand.class);
	}

	protected String getSuccessMessage(ActionRequest actionRequest) {
		return LanguageUtil.get(
			getResourceBundle(actionRequest), "workflow-updated-successfully");
	}

	protected String getTitle(
		ActionRequest actionRequest, Map<Locale, String> titleMap) {

		if (titleMap == null) {
			return null;
		}

		addDefaultTitle(actionRequest, titleMap);

		String value = StringPool.BLANK;

		for (Locale locale : LanguageUtil.getAvailableLocales()) {
			String languageId = LocaleUtil.toLanguageId(locale);
			String title = titleMap.get(locale);

			if (Validator.isNotNull(title)) {
				value = LocalizationUtil.updateLocalization(
					value, "Title", title, languageId);
			}
			else {
				value = LocalizationUtil.removeLocalization(
					value, "Title", languageId);
			}
		}

		return value;
	}

	@Reference
	protected WorkflowDefinitionManager workflowDefinitionManager;

}