/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_EDITABLE_VALUES} from './types';

export default function updateEditableValues({
	editableValues,
	fragmentEntryLinkId,
	segmentsExperienceId,
}) {
	return {
		editableValues,
		fragmentEntryLinkId,
		segmentsExperienceId,
		type: UPDATE_EDITABLE_VALUES,
	};
}
