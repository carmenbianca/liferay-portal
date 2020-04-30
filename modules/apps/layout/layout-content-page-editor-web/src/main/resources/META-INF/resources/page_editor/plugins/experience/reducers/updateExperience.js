/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

function updateExperienceReducer(state, payload) {
	let nextState = state;

	const updatedExperience = payload;

	const experience =
		state.availableSegmentsExperiences[
			updatedExperience.segmentsExperienceId
		];

	if (experience) {
		nextState = {
			...nextState,
			availableSegmentsExperiences: {
				...nextState.availableSegmentsExperiences,
				[experience.segmentsExperienceId]: {
					...updatedExperience,
					priority: experience.priority,
				},
			},
		};
	}

	return nextState;
}

export default updateExperienceReducer;
