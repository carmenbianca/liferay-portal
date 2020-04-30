/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.kernel.template;

import com.liferay.portal.kernel.util.EscapableLocalizableFunction;
import com.liferay.portal.kernel.util.EscapableObject;

/**
 * @author Adolfo Pérez
 */
public interface MailTemplateContextBuilder {

	public MailTemplateContext build();

	public MailTemplateContextBuilder put(
		String name, EscapableLocalizableFunction escapableLocalizableFunction);

	public MailTemplateContextBuilder put(
		String name, EscapableObject<String> escapableObject);

	public MailTemplateContextBuilder put(String name, String value);

}