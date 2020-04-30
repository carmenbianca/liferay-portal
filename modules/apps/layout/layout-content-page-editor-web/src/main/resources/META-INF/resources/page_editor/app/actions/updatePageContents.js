/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_PAGE_CONTENTS} from './types';

export default function updateLayoutData({pageContents}) {
	return {
		pageContents,
		type: UPDATE_PAGE_CONTENTS,
	};
}
