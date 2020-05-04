/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.filter;

import com.liferay.portal.search.query.Query;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ComplexQueryPartBuilder {

	public ComplexQueryPartBuilder additive(boolean additive);

	public ComplexQueryPartBuilder boost(Float boost);

	public ComplexQueryPart build();

	public ComplexQueryPartBuilder disabled(boolean disabled);

	public ComplexQueryPartBuilder field(String field);

	public ComplexQueryPartBuilder name(String name);

	public ComplexQueryPartBuilder occur(String occur);

	public ComplexQueryPartBuilder parent(String parent);

	public ComplexQueryPartBuilder query(Query query);

	public ComplexQueryPartBuilder type(String type);

	public ComplexQueryPartBuilder value(String value);

}