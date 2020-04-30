/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

export const formDataToObj = formData =>
	Array.from(formData.entries()).reduce((accumulator, [key, value]) => {
		accumulator[key] = value;

		return accumulator;
	}, {});
