/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	selectExperience,
	setExperimentStatus,
	setUsedWidgets,
	switchLayoutData,
} from './utils';

function selectExperienceReducer(state, payload) {
	let nextState = state;

	const {portletIds, segmentsExperienceId} = payload;

	nextState = switchLayoutData(nextState, {
		currentExperienceId: nextState.segmentsExperienceId,
		targetExperienceId: segmentsExperienceId,
	});

	nextState = setUsedWidgets(nextState, {portletIds});

	nextState = selectExperience(nextState, segmentsExperienceId);

	nextState = setExperimentStatus(nextState, segmentsExperienceId);

	return nextState;
}

export default selectExperienceReducer;
