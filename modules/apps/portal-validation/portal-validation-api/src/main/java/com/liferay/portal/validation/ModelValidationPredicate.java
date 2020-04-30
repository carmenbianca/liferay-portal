/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.validation;

import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Máté Thurzó
 */
@FunctionalInterface
public interface ModelValidationPredicate<T extends ClassedModel> {

	public ModelValidationResults test(T model);

}