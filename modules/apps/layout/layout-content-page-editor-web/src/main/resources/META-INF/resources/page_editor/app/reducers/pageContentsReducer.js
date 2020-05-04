/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {UPDATE_PAGE_CONTENTS} from '../actions/types';

const INITIAL_STATE = [];

export default function pageContentsReducer(
	pageContents = INITIAL_STATE,
	action
) {
	switch (action.type) {
		case UPDATE_PAGE_CONTENTS:
			return [...action.pageContents];

		default:
			return pageContents;
	}
}
