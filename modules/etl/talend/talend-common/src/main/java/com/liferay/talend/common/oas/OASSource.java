/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.common.oas;

import javax.json.JsonObject;

import org.talend.components.api.properties.ComponentProperties;
import org.talend.daikon.properties.ValidationResult;

/**
 * @author Igor Beslic
 */
public interface OASSource {

	public JsonObject getOASJsonObject();

	public JsonObject getOASJsonObject(String oasUrl);

	public ValidationResult initialize(ComponentProperties componentProperties);

}