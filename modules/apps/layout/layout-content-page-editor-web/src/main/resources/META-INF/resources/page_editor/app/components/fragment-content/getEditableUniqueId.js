/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

/**
 * @param {string} fragmentEntryLinkId
 * @param {string} editableId
 */
export default function getEditableUniqueId(fragmentEntryLinkId, editableId) {
	return `${fragmentEntryLinkId}-${editableId}`;
}
