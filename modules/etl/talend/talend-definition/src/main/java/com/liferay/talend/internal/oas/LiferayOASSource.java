/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.internal.oas;

import com.liferay.talend.common.oas.OASSource;

import javax.json.JsonObject;

import org.talend.components.api.properties.ComponentProperties;
import org.talend.daikon.properties.ValidationResult;

/**
 * @author Igor Beslic
 */
public class LiferayOASSource implements OASSource {

	public LiferayOASSource(
		OASSource oasSource, ValidationResult validationResult) {

		_oasSource = oasSource;
		_validationResult = validationResult;
	}

	@Override
	public JsonObject getOASJsonObject() {
		throw new UnsupportedOperationException(
			"Unable to resolve OAS without URL");
	}

	@Override
	public JsonObject getOASJsonObject(String oasUrl) {
		return _oasSource.getOASJsonObject(oasUrl);
	}

	public ValidationResult getValidationResult() {
		return _validationResult;
	}

	@Override
	public ValidationResult initialize(
		ComponentProperties componentProperties) {

		throw new UnsupportedOperationException(
			"OAS source object is already initialized");
	}

	public boolean isValid() {
		if (_validationResult.getStatus() == ValidationResult.Result.ERROR) {
			return false;
		}

		return true;
	}

	private final OASSource _oasSource;
	private final ValidationResult _validationResult;

}