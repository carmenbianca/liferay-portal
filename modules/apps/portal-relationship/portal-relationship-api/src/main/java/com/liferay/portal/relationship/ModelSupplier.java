/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.relationship;

import com.liferay.portal.kernel.model.ClassedModel;

import java.io.Serializable;

/**
 * @author Máté Thurzó
 */
@FunctionalInterface
public interface ModelSupplier<T extends Serializable, U extends ClassedModel> {

	public U supply(T primKey);

}