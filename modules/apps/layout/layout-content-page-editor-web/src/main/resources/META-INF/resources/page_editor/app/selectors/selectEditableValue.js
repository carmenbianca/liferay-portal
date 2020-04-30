/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {EDITABLE_FRAGMENT_ENTRY_PROCESSOR} from '../config/constants/editableFragmentEntryProcessor';

export default function selectEditableValue(
	state,
	fragmentEntryLinkId,
	editableId,
	processorType = EDITABLE_FRAGMENT_ENTRY_PROCESSOR
) {
	const fragmentEntryLink = state.fragmentEntryLinks[fragmentEntryLinkId];

	return (
		(fragmentEntryLink &&
			fragmentEntryLink.editableValues &&
			fragmentEntryLink.editableValues[processorType] &&
			fragmentEntryLink.editableValues[processorType][editableId]) ||
		{}
	);
}
