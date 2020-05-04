/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.field.customizer;

import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides methods for retrieving segment field customizers defined by {@link
 * SegmentsFieldCustomizer} implementations.
 *
 * @author Eduardo García
 */
@ProviderType
public interface SegmentsFieldCustomizerRegistry {

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getSegmentsFieldCustomizerOptional(String, String)}
	 */
	@Deprecated
	public Optional<SegmentsFieldCustomizer> getSegmentFieldCustomizerOptional(
		String entityName, String fieldName);

	public Optional<SegmentsFieldCustomizer> getSegmentsFieldCustomizerOptional(
		String entityName, String fieldName);

}