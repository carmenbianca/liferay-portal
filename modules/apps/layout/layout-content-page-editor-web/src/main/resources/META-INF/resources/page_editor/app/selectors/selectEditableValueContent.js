/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {config} from '../config/index';
import selectEditableValue from './selectEditableValue';
import selectPrefixedSegmentsExperienceId from './selectPrefixedSegmentsExperienceId';

export default function selectEditableValueContent(
	state,
	fragmentEntryLinkId,
	editableId,
	processorType
) {
	const {languageId} = state;
	const prefixedSegmentsExperienceId = selectPrefixedSegmentsExperienceId(
		state
	);

	const data = selectEditableValue(
		state,
		fragmentEntryLinkId,
		editableId,
		processorType
	);

	let content = data;

	if (content[prefixedSegmentsExperienceId]) {
		content = content[prefixedSegmentsExperienceId];
	}

	if (content[languageId]) {
		content = content[languageId];
	}
	else if (content[config.defaultLanguageId]) {
		content = content[config.defaultLanguageId];
	}

	if (typeof content !== 'string') {
		content = data.defaultValue;
	}

	return content;
}
