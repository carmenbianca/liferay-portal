/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import objectHash from 'object-hash';

const hash = value =>
	objectHash(value, {
		algorithm: 'md5',
		unorderedObjects: true,
	});

export {hash};
export default hash;
