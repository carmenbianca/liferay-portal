/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.web.internal.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.settings.ModifiableSettings;
import com.liferay.portal.kernel.settings.Settings;
import com.liferay.portal.kernel.settings.SettingsDescriptor;
import com.liferay.portal.kernel.settings.SettingsException;
import com.liferay.portal.kernel.settings.SettingsFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.settings.portlet.action.PortalSettingsFormContributor;

import java.io.IOException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ValidatorException;

/**
 * @author Michael C. Han
 */
public class SavePortalSettingsFormMVCActionCommand
	extends BasePortalSettingsFormMVCActionCommand {

	public SavePortalSettingsFormMVCActionCommand(
		PortalSettingsFormContributor portalSettingsFormContributor) {

		super(portalSettingsFormContributor);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			portalSettingsFormContributor.validateForm(
				actionRequest, actionResponse);

			if (!SessionErrors.isEmpty(actionRequest)) {
				throw new PortalException();
			}

			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			if (!hasPermissions(actionRequest, actionResponse, themeDisplay)) {
				return;
			}

			storeSettings(actionRequest, themeDisplay);
		}
		catch (PortalException portalException) {
			SessionErrors.add(
				actionRequest, portalException.getClass(), portalException);

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}
	}

	@Override
	protected void doValidateForm(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	}

	protected String getParameterNamespace() {
		return portalSettingsFormContributor.getParameterNamespace();
	}

	protected String getString(ActionRequest actionRequest, String name) {
		return ParamUtil.getString(
			actionRequest, getParameterNamespace() + name);
	}

	protected String[] getStrings(ActionRequest actionRequest, String name) {
		String value = getString(actionRequest, name + "Indexes");

		if (Validator.isNull(value)) {
			return null;
		}

		Stream<String> stream = Arrays.stream(value.split(","));

		return stream.map(
			index -> getString(actionRequest, name.concat(index))
		).filter(
			Validator::isNotNull
		).toArray(
			String[]::new
		);
	}

	protected void storeSettings(
			ActionRequest actionRequest, ThemeDisplay themeDisplay)
		throws IOException, SettingsException, ValidatorException {

		Settings settings = SettingsFactoryUtil.getSettings(
			new CompanyServiceSettingsLocator(
				themeDisplay.getCompanyId(), getSettingsId()));

		ModifiableSettings modifiableSettings =
			settings.getModifiableSettings();

		SettingsDescriptor settingsDescriptor =
			SettingsFactoryUtil.getSettingsDescriptor(getSettingsId());

		Set<String> multiValuedKeys = new HashSet<>(
			settingsDescriptor.getMultiValuedKeys());

		for (String name : settingsDescriptor.getAllKeys()) {
			if (multiValuedKeys.remove(name)) {
				modifiableSettings.setValues(
					name, getStrings(actionRequest, name));

				continue;
			}

			String value = getString(actionRequest, name);

			if (value.equals(Portal.TEMP_OBFUSCATION_VALUE)) {
				continue;
			}

			String oldValue = settings.getValue(name, null);

			if (!value.equals(oldValue)) {
				modifiableSettings.setValue(name, value);
			}
		}

		modifiableSettings.store();
	}

}