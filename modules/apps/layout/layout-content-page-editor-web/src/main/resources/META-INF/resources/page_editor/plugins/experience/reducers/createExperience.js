/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	addExperience,
	storeNewLayoutData,
	updateFragmentEntryLinksEditableValues,
} from './utils';

function createExperienceReducer(state, payload) {
	let nextState = state;

	const {fragmentEntryLinks, layoutData, segmentsExperience} = payload;

	const newExperience = {
		...segmentsExperience,
		hasLockedSegmentsExperiment: false,
	};

	nextState = addExperience(nextState, newExperience);
	nextState = storeNewLayoutData(
		nextState,
		newExperience.segmentsExperienceId,
		layoutData
	);
	nextState = updateFragmentEntryLinksEditableValues(
		nextState,
		fragmentEntryLinks
	);

	return nextState;
}

export default createExperienceReducer;
