/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {deleteExperienceById, removeLayoutDataItemById} from './utils';

function deleteExperienceReducer(state, payload) {
	let nextState = state;
	const {segmentsExperienceId} = payload;

	nextState = removeLayoutDataItemById(nextState, segmentsExperienceId);
	nextState = deleteExperienceById(nextState, segmentsExperienceId);

	return nextState;
}

export default deleteExperienceReducer;
