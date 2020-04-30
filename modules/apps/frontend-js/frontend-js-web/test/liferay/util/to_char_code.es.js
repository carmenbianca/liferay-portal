/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

'use strict';

import toCharCode from '../../../src/main/resources/META-INF/resources/liferay/util/to_char_code.es';

describe('Liferay.Util.toCharCode', () => {
	it('returns string', () => {
		const result = toCharCode('liferay');

		expect(typeof result).toBe('string');
		expect(result).toMatchSnapshot();
	});
});
