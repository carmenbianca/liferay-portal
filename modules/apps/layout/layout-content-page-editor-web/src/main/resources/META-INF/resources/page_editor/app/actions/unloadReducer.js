/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UNLOAD_REDUCER} from './types';

export default function unloadReducer(key) {
	return {
		key,
		type: UNLOAD_REDUCER,
	};
}
