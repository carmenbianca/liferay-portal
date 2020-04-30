/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DELETE_SEGMENTS_EXPERIENCE} from './types';

export default function deleteExperience({portletIds, segmentsExperienceId}) {
	return {
		payload: {
			portletIds,
			segmentsExperienceId,
		},
		type: DELETE_SEGMENTS_EXPERIENCE,
	};
}
