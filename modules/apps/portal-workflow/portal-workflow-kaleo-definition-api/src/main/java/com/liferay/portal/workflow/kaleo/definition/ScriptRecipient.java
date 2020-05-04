/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Val Nagy
 */
public class ScriptRecipient extends Recipient {

	public ScriptRecipient(
		String script, String scriptLanguage, String scriptRequiredContexts) {

		super(RecipientType.SCRIPT);

		_script = script;
		_scriptLanguage = ScriptLanguage.parse(scriptLanguage);
		_scriptRequiredContexts = scriptRequiredContexts;
	}

	public String getScript() {
		return _script;
	}

	public ScriptLanguage getScriptLanguage() {
		return _scriptLanguage;
	}

	public String getScriptRequiredContexts() {
		return _scriptRequiredContexts;
	}

	public void setScript(String script) {
		_script = script;
	}

	public void setScriptLanguage(ScriptLanguage scriptLanguage) {
		_scriptLanguage = scriptLanguage;
	}

	private String _script;
	private ScriptLanguage _scriptLanguage;
	private final String _scriptRequiredContexts;

}