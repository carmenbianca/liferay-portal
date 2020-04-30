/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_SEGMENTS_EXPERIENCE_PRIORITY} from './types';

export default function updateExperiencePriority({subtarget, target}) {
	return {
		payload: {
			subtarget,
			target,
		},
		type: UPDATE_SEGMENTS_EXPERIENCE_PRIORITY,
	};
}
