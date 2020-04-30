/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ADD_FRAGMENT_ENTRY_LINKS} from './types';

/**
 * @param {object} data
 * @param {object[]} data.fragmentEntryLinks
 * @param {object} data.layoutData
 */
export default function addFragmentEntryLinks({
	fragmentEntryLinks,
	layoutData,
}) {
	return {
		fragmentEntryLinks,
		layoutData,
		type: ADD_FRAGMENT_ENTRY_LINKS,
	};
}
