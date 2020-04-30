/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {TOGGLE_SHOW_RESOLVED_COMMENTS} from './types';

export default function toggleShowResolvedComments({showResolvedComments}) {
	return {
		showResolvedComments,
		type: TOGGLE_SHOW_RESOLVED_COMMENTS,
	};
}
