/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SWITCH_VIEWPORT_SIZE} from '../actions/types';

export const INITIAL_STATE = 'desktop';

export default function selectedViewportSizeReducer(
	viewportStatus = INITIAL_STATE,
	action
) {
	if (action.type === SWITCH_VIEWPORT_SIZE) {
		return action.size;
	}

	return viewportStatus;
}
