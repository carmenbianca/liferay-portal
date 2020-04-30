/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.kernel.template;

/**
 * @author Adolfo Pérez
 */
public interface MailTemplateFactory {

	public MailTemplate createMailTemplate(String template, boolean escapeHTML);

	public MailTemplateContextBuilder createMailTemplateContextBuilder();

}