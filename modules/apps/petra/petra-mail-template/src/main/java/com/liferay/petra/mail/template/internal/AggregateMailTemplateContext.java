/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.mail.template.internal;

import com.liferay.mail.kernel.template.MailTemplateContext;
import com.liferay.portal.kernel.util.EscapableLocalizableFunction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adolfo Pérez
 */
public class AggregateMailTemplateContext implements MailTemplateContext {

	public AggregateMailTemplateContext(
		MailTemplateContext... mailTemplateContexts) {

		Map<String, EscapableLocalizableFunction> replacements =
			new HashMap<>();

		for (MailTemplateContext mailTemplateContext : mailTemplateContexts) {
			replacements.putAll(mailTemplateContext.getReplacements());
		}

		_replacements = Collections.unmodifiableMap(replacements);
	}

	@Override
	public MailTemplateContext aggregateWith(
		MailTemplateContext mailTemplateContext) {

		return new AggregateMailTemplateContext(this, mailTemplateContext);
	}

	@Override
	public Map<String, EscapableLocalizableFunction> getReplacements() {
		return _replacements;
	}

	private final Map<String, EscapableLocalizableFunction> _replacements;

}