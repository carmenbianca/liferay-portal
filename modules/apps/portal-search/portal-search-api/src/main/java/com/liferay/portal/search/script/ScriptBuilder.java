/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.script;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface ScriptBuilder {

	public Script build();

	public ScriptBuilder idOrCode(String idOrCode);

	public ScriptBuilder language(String language);

	public ScriptBuilder options(Map<String, String> optionsMap);

	public ScriptBuilder parameters(Map<String, Object> parametersMap);

	public ScriptBuilder putOption(String optionName, String optionValue);

	public ScriptBuilder putParameter(
		String parameterName, Object parameterValue);

	public ScriptBuilder scriptType(ScriptType scriptType);

}