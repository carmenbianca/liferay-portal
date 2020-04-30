/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {
	CREATE_SEGMENTS_EXPERIENCE,
	DELETE_SEGMENTS_EXPERIENCE,
	SELECT_SEGMENTS_EXPERIENCE,
	UPDATE_SEGMENTS_EXPERIENCE,
	UPDATE_SEGMENTS_EXPERIENCE_PRIORITY,
} from '../actions';
import createExperienceReducer from './createExperience';
import deleteExperienceReducer from './deleteExperience';
import selectExperienceReducer from './selectExperience';
import updateExperienceReducer from './updateExperience';
import updateExperiencePriorityReducer from './updateExperiencePriority';

const reducer = (state, action) => {
	let nextState = state;

	switch (action.type) {
		case CREATE_SEGMENTS_EXPERIENCE:
			nextState = createExperienceReducer(nextState, action.payload);
			break;
		case DELETE_SEGMENTS_EXPERIENCE:
			nextState = deleteExperienceReducer(nextState, action.payload);
			break;
		case UPDATE_SEGMENTS_EXPERIENCE:
			nextState = updateExperienceReducer(nextState, action.payload);
			break;
		case SELECT_SEGMENTS_EXPERIENCE:
			nextState = selectExperienceReducer(nextState, action.payload);
			break;
		case UPDATE_SEGMENTS_EXPERIENCE_PRIORITY:
			nextState = updateExperiencePriorityReducer(
				nextState,
				action.payload
			);
			break;
		default:
			break;
	}

	return nextState;
};

export default reducer;
