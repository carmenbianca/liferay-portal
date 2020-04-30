/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * @param {{ permissions: import("../../types/ActionKeys").ActionKeysMap }} state
 */
export default function selectCanUpdate({permissions}) {
	return !permissions.LOCKED_SEGMENTS_EXPERIMENT && permissions.UPDATE;
}
