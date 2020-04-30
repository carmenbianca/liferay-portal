/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export default function isMapped(editable) {
	return (
		editable &&
		(editable.fieldId || editable.mappedField || editable.collectionFieldId)
	);
}
