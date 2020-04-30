/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SEGMENTS_EXPERIENCE_ID_PREFIX} from '../config/constants/segmentsExperienceIdPrefix';
import selectSegmentsExperienceId from './selectSegmentsExperienceId';

/**
 * Returns the selected segmentsExperienceId or the default one.
 * Warning: this function may return an empty string if the editor is
 * being used in an environment without experiences (ex. Page Templates).
 *
 * @param {object} state
 * @return {string}
 */
export default function selectPrefixedSegmentsExperienceId(state) {
	const segmentsExperienceId = selectSegmentsExperienceId(state);

	return segmentsExperienceId
		? `${SEGMENTS_EXPERIENCE_ID_PREFIX}${selectSegmentsExperienceId(state)}`
		: '';
}
