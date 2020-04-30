/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export type ACTION_KEYS =
	| 'EDIT_SEGMENTS_ENTRY'
	| 'LOCKED_SEGMENTS_EXPERIMENT'
	| 'UPDATE'
	| 'UPDATE_LAYOUT_CONTENT';

export type ActionKeysMap = {
	[key in ACTION_KEYS]: boolean;
};
