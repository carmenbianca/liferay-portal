/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.validation;

import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Máté Thurzó
 */
public class ModelValidatorUtil {

	public static <T extends ClassedModel> ModelValidationResults validate(
		ModelValidationPredicate<T> predicate, T model) {

		return predicate.test(model);
	}

	public static <T extends ClassedModel> ModelValidationResults validate(
		T model) {

		ModelValidator<T> modelValidator =
			ModelValidatorRegistryUtil.getModelValidator(
				model.getModelClassName());

		if (modelValidator == null) {
			return ModelValidationResults.success();
		}

		return validate(modelValidator::validateModel, model);
	}

}