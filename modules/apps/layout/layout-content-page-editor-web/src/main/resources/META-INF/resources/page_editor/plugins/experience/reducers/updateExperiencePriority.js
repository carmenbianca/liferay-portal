/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

function updateExperiencePriorityReducer(state, {subtarget, target}) {
	const experiences = state.availableSegmentsExperiences;

	const targetExperience = {
		...experiences[target.segmentsExperienceId],
		priority: target.priority,
	};
	const subtargetExperience = {
		...experiences[subtarget.segmentsExperienceId],
		priority: subtarget.priority,
	};

	const updatedExperiences = {
		...experiences,
		[target.segmentsExperienceId]: targetExperience,
		[subtarget.segmentsExperienceId]: subtargetExperience,
	};

	return {
		...state,
		availableSegmentsExperiences: updatedExperiences,
	};
}

export default updateExperiencePriorityReducer;
