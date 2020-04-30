/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {isObject} from 'metal';

/**
 * Returns a FormData containing serialized object.
 * @param {!Object} obj Object to convert to a URLSearchParams
 * @return {URLSearchParams} URLSearchParams object with the set parameters
 * @review
 */

export default function objectToURLSearchParams(obj) {
	if (!isObject(obj)) {
		throw new TypeError('Parameter obj must be an object');
	}

	const urlSearchParams = new URLSearchParams();

	Object.entries(obj).forEach(([key, value]) => {
		if (Array.isArray(value)) {
			for (let i = 0; i < value.length; i++) {
				urlSearchParams.append(key, value[i]);
			}
		}
		else {
			urlSearchParams.append(key, value);
		}
	});

	return urlSearchParams;
}
