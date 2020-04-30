/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.relationship;

import java.util.Collection;

/**
 * @author Máté Thurzó
 */
@FunctionalInterface
public interface MultiRelationshipFunction<T, U> {

	public Collection<U> apply(T model);

}