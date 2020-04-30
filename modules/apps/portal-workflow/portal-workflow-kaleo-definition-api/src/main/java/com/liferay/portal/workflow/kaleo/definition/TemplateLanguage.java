/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

import java.util.Objects;

/**
 * @author Michael C. Han
 */
public enum TemplateLanguage {

	FREEMARKER("freemarker"), TEXT("text"), VELOCITY("velocity");

	public static TemplateLanguage parse(String value) {
		if (Objects.equals(FREEMARKER.getValue(), value)) {
			return FREEMARKER;
		}
		else if (Objects.equals(TEXT.getValue(), value)) {
			return TEXT;
		}
		else if (Objects.equals(VELOCITY.getValue(), value)) {
			return VELOCITY;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private TemplateLanguage(String value) {
		_value = value;
	}

	private final String _value;

}