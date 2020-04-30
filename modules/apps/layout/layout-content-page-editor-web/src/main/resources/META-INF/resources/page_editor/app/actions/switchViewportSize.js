/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {SWITCH_VIEWPORT_SIZE} from './types';

export default function switchViewportSize({size}) {
	return {
		size,
		type: SWITCH_VIEWPORT_SIZE,
	};
}
