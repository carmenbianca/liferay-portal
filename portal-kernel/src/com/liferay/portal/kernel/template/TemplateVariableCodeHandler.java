/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

/**
 * @author Marcellus Tavares
 */
public interface TemplateVariableCodeHandler {

	public String[] generate(
			TemplateVariableDefinition templateVariableDefinition,
			String language)
		throws Exception;

}