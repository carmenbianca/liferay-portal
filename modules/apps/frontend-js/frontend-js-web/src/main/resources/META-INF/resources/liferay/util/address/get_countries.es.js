/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {isFunction} from 'metal';

/**
 * Returns a list of countries
 * @callback callback
 * @return {array} Array of countries
 */
export default function getCountries(callback) {
	if (!isFunction(callback)) {
		throw new TypeError('Parameter callback must be a function');
	}

	Liferay.Service(
		'/country/get-countries',
		{
			active: true,
		},
		callback
	);
}
