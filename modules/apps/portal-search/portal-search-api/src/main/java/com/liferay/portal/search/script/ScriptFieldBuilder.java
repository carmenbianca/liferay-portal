/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.script;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface ScriptFieldBuilder {

	public ScriptField build();

	public ScriptFieldBuilder field(String field);

	public ScriptFieldBuilder ignoreFailure(boolean ignoreFailure);

	public ScriptFieldBuilder script(Script script);

}