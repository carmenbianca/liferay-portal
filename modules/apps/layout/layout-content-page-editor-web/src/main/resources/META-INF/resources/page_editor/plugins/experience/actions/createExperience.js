/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {CREATE_SEGMENTS_EXPERIENCE} from '../actions/types';

export default function createExperience({
	fragmentEntryLinks,
	layoutData,
	segmentsExperience,
}) {
	return {
		payload: {
			fragmentEntryLinks,
			layoutData,
			segmentsExperience,
		},
		type: CREATE_SEGMENTS_EXPERIENCE,
	};
}
