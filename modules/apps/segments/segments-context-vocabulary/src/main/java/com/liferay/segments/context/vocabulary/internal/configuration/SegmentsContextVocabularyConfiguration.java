/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.context.vocabulary.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Raymond Augé
 */
@ExtendedObjectClassDefinition(
	category = "segments", factoryInstanceLabelAttribute = "entityField",
	generateUI = false
)
@Meta.OCD(
	description = "segments-context-vocabulary-configuration-description",
	factory = true,
	id = "com.liferay.segments.context.vocabulary.internal.configuration.SegmentsContextVocabularyConfiguration",
	localization = "content/Language",
	name = "segments-context-vocabulary-configuration-name"
)
public interface SegmentsContextVocabularyConfiguration {

	@Meta.AD(
		description = "segments-context-vocabulary-configuration-entity-field-description",
		name = "segments-context-vocabulary-configuration-entity-field-name"
	)
	public String entityField();

	@Meta.AD(
		description = "segments-context-vocabulary-configuration-asset-vocabulary-description",
		name = "segments-context-vocabulary-configuration-asset-vocabulary-name"
	)
	public String assetVocabulary();

}