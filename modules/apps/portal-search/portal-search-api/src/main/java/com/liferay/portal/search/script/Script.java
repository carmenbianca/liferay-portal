/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.script;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface Script {

	public String getIdOrCode();

	public String getLanguage();

	public Map<String, String> getOptions();

	public Map<String, Object> getParameters();

	public ScriptType getScriptType();

}