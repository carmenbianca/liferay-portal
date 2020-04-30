/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {TOGGLE_SHOW_RESOLVED_COMMENTS} from '../actions/types';

export const INITIAL_STATE = false;

export default function showResolvedCommentsReducer(
	toggleResolvedComments = INITIAL_STATE,
	action
) {
	switch (action.type) {
		case TOGGLE_SHOW_RESOLVED_COMMENTS:
			return action.showResolvedComments;

		default:
			return toggleResolvedComments;
	}
}
