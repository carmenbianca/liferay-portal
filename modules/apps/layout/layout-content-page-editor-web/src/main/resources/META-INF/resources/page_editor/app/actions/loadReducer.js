/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {LOAD_REDUCER} from './types';

export default function loadReducer(reducer, key) {
	return {
		key,
		reducer,
		type: LOAD_REDUCER,
	};
}
