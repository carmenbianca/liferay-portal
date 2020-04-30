/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import * as TYPES from '../actions/types';

export const INITIAL_STATE = 'en-US';

export default function languageReducer(languageId = INITIAL_STATE, action) {
	switch (action.type) {
		case TYPES.UPDATE_LANGUAGE_ID:
			return action.languageId;

		default:
			return languageId;
	}
}
