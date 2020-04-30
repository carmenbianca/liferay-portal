/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.script;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
public interface Scripts {

	public ScriptBuilder builder();

	public ScriptFieldBuilder fieldBuilder();

	public Script inline(String language, String code);

	public Script script(String idOrCode);

	public ScriptField scriptField(String field, Script script);

	public Script stored(String scriptId);

}