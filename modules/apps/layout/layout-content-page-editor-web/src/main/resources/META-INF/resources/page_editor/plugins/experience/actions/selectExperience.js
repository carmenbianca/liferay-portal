/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SELECT_SEGMENTS_EXPERIENCE} from './types';

export default function selectExperience({
	portletIds = [],
	segmentsExperienceId,
}) {
	return {
		payload: {
			portletIds,
			segmentsExperienceId,
		},
		type: SELECT_SEGMENTS_EXPERIENCE,
	};
}
