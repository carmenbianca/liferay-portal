/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

'use strict';

import objectToURLSearchParams from '../../../src/main/resources/META-INF/resources/liferay/util/object_to_url_search_params.es';

describe('Liferay.Util.objectToURLSearchParams', () => {
	it('throws error if obj parameter is not an object', () => {
		expect(() => objectToURLSearchParams('abc')).toThrow(
			'must be an object'
		);
	});

	it('converts given object into URLSearchParams', () => {
		const obj = {
			key1: 'value1',
			key2: 123,
		};

		const urlSearchParams = objectToURLSearchParams(obj);

		expect(urlSearchParams.constructor.name).toEqual('URLSearchParams');

		expect(urlSearchParams.get('key1')).toEqual('value1');
		expect(urlSearchParams.get('key2')).toEqual('123');
	});

	it('converts given object parameter with array value into multiple request parameters with the same key', () => {
		const obj = {
			key: ['abc', 'def'],
		};

		const urlSearchParams = objectToURLSearchParams(obj);

		expect(urlSearchParams.getAll('key')).toEqual(['abc', 'def']);
	});
});
