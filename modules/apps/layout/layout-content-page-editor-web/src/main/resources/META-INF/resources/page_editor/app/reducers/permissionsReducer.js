/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {TOGGLE_PERMISSION} from '../actions/types';

/**
 * @type {import('../../types/ActionKeys').ActionKeysMap}
 */
export const INITIAL_STATE = {
	EDIT_SEGMENTS_ENTRY: false,
	LOCKED_SEGMENTS_EXPERIMENT: false,
	UPDATE: true,
	UPDATE_LAYOUT_CONTENT: true,
};

/**
 *
 * @param {import('../../types/ActionKeys').ActionKeysMap} state
 * @param {object} action
 * @param {string} action.type
 * @param {import('../../types/ActionKeys').ACTION_KEYS} action.key
 * @param {boolean} [action.forceNewValue]
 */
export default function permissionsReducer(state = INITIAL_STATE, action) {
	switch (action.type) {
		case TOGGLE_PERMISSION:
			return {
				...state,
				[action.key]:
					typeof action.forceNewValue === 'undefined'
						? !state[action.key]
						: action.forceNewValue,
			};

		default:
			return state;
	}
}
