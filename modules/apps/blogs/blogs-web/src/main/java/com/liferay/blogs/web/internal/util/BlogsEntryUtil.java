/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.util;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = BlogsEntryUtil.class)
public class BlogsEntryUtil {

	public static String getDisplayTitle(
		ResourceBundle resourceBundle, BlogsEntry entry) {

		if (Validator.isNull(entry.getTitle())) {
			return LanguageUtil.get(resourceBundle, "untitled-entry");
		}

		return entry.getTitle();
	}

}