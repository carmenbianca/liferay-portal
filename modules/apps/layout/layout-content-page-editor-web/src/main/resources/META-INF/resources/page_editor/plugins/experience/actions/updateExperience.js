/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_SEGMENTS_EXPERIENCE} from './types';

export default function updateExperience({
	name,
	segmentsEntryId,
	segmentsExperienceId,
}) {
	return {
		payload: {
			name,
			segmentsEntryId,
			segmentsExperienceId,
		},
		type: UPDATE_SEGMENTS_EXPERIENCE,
	};
}
