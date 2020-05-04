/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.web.internal.portlet.validator;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.rss.constants.RSSPortletKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.PreferencesValidator;
import javax.portlet.ValidatorException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	immediate = true, property = "javax.portlet.name=" + RSSPortletKeys.RSS,
	service = PreferencesValidator.class
)
public class RSSPreferencesValidator implements PreferencesValidator {

	@Override
	public void validate(PortletPreferences preferences)
		throws ValidatorException {

		List<String> badURLs = new ArrayList<>();

		String[] urls = preferences.getValues("urls", new String[0]);

		for (String url : urls) {
			if (!Validator.isUrl(url)) {
				badURLs.add(url);
			}
		}

		if (!badURLs.isEmpty()) {
			throw new ValidatorException("Failed to retrieve URLs", badURLs);
		}
	}

}