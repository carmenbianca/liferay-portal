/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.model.DDMForm;

import java.lang.annotation.Annotation;

/**
 * @author Marcellus Tavares
 */
public class DDMFormFactory {

	public static DDMForm create(Class<?> clazz) {
		if (!clazz.isAnnotationPresent(_DDM_FORM_ANNOTATION)) {
			throw new IllegalArgumentException(
				"Unsupported class " + clazz.getName());
		}

		DDMFormFactoryHelper ddmFormFactoryHelper = new DDMFormFactoryHelper(
			clazz);

		return ddmFormFactoryHelper.createDDMForm();
	}

	private static final Class<? extends Annotation> _DDM_FORM_ANNOTATION =
		com.liferay.dynamic.data.mapping.annotations.DDMForm.class;

}