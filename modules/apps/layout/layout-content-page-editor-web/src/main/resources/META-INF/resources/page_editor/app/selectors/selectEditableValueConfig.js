/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import selectEditableValue from './selectEditableValue';

export default function selectEditableValueConfig(
	state,
	fragmentEntryLinkId,
	editableId,
	processorType
) {
	return (
		selectEditableValue(
			state,
			fragmentEntryLinkId,
			editableId,
			processorType
		).config || {}
	);
}
