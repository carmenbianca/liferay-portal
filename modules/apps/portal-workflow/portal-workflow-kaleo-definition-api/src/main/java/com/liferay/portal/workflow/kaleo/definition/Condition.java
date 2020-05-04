/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

/**
 * @author Michael C. Han
 */
public class Condition extends Node {

	public Condition(
		String name, String description, String script, String scriptLanguage,
		String scriptRequiredContexts) {

		super(NodeType.CONDITION, name, description);

		_description = description;
		_script = script;
		_scriptLanguage = ScriptLanguage.parse(scriptLanguage);
		_scriptRequiredContexts = scriptRequiredContexts;
	}

	@Override
	public String getDescription() {
		return _description;
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

	private final String _description;
	private final String _script;
	private final ScriptLanguage _scriptLanguage;
	private final String _scriptRequiredContexts;

}