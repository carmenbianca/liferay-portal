/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DELETE_WIDGETS} from './types';

export default function deleteWidgets(fragmentEntryLinks = []) {
	return {
		fragmentEntryLinks,
		type: DELETE_WIDGETS,
	};
}
