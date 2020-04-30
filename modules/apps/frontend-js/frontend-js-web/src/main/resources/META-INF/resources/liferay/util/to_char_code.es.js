/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import memoize from 'lodash.memoize';

const toCharCode = memoize(name =>
	name
		.split('')
		.map(val => val.charCodeAt())
		.join('')
);

export default toCharCode;
