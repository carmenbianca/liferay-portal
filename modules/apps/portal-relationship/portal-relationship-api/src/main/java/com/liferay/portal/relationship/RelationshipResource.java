/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.relationship;

import com.liferay.portal.kernel.model.ClassedModel;

/**
 * @author Máté Thurzó
 */
public interface RelationshipResource<T extends ClassedModel> {

	public Relationship<T> relationship(Relationship.Builder<T> builder);

}